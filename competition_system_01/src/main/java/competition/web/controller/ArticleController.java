package competition.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import util.AuthUtils;
import util.BeanUtils;
import util.FileUtils;

import competition.domain.Article;
import competition.domain.Comment;
import competition.domain.Page;
import competition.domain.Pagination;
import competition.domain.code.BoardCode;
import competition.domain.view.ArticleView;
import competition.domain.view.AuthView;
import competition.domain.view.CommentView;
import competition.domain.view.ContentView;
import competition.domain.view.FileView;
import competition.domain.view.TagView;
import competition.domain.view.code.BoardCodeView;
import competition.domain.view.code.TeamCodeView;
import competition.service.ArticleService;
import competition.service.CommentService;
import competition.service.FileService;
import competition.service.ScoreService;
import competition.service.TagService;
import competition.service.TeamService;
import competition.service.UserService;

@Controller
public class ArticleController  {
	@Autowired
	ArticleService articleService;
	@Autowired
	UserService userService;
	@Autowired
	TeamService teamService;
	@Autowired
	CommentService commentService;
	@Autowired
	FileService fileService;
	@Autowired
	ScoreService scoreService;
	@Autowired
	TagService tagService;
	
	@ModelAttribute
	private void addModelData(HttpServletRequest request, Model model, Pagination pagination) {
		if (pagination != null) {
			String subTitle = articleService.getBoardName(pagination.getBid());
			BoardCodeView bcv = articleService.getBoard(pagination.getBid());
			List<Page> pgList = new ArrayList<Page>();
			String selectedURI = "";
			
			if(bcv != null) {
				pgList.addAll(articleService.getSubList(bcv.getParentBoardCodeId()));
			
				// context 명 제외한 이후 경로 명 - 게시판일 경우
				selectedURI = request.getRequestURI();
				selectedURI = selectedURI.substring(selectedURI.indexOf("/", selectedURI.indexOf("/") + 1) + 1) + "?bid=" + pagination.getBid();
				
				model.addAttribute("selectedURI", selectedURI);
			} 
//			System.out.println(selectedURI);
			if(pagination.getIsShare() == 1)
				subTitle = "대회자료";
			
			model.addAttribute("subTitle", subTitle);
			model.addAttribute("pgList", pgList);
		}
	}
	
	// Board
	@RequestMapping("/{boardType}/board.do")
	public ModelAndView getBoard(@PathVariable String boardType,
			@ModelAttribute("pagination") Pagination pagination) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();	
		ModelAndView modelAndView = new ModelAndView("/" + boardType + "/board");
		boolean isWrite = false;
		int boardCount = articleService.getTotalArticles(pagination);
		List<ArticleView> avList = articleService.findArticles(pagination);
		List<AuthView> authList = userService.getAllAuths();
		BoardCodeView boardCodeView = articleService.getBoard(pagination.getBoardCodeId());
		List<String> authNames = AuthUtils.getAuthNames(authList, boardCodeView.getWriteLevel());
		
		// bid가 없을 경우
		if(pagination.getBid() == 0 && pagination.getIs() == 0){
			modelAndView.setViewName("redirect:/main/main.do");
			return modelAndView;
		}
		
		for(GrantedAuthority granted : auth.getAuthorities()) 
			if(authNames.contains(granted.getAuthority()))
				isWrite = true;
		//System.out.println(isWrite);

		// Test
		try {
			System.out.println(BeanUtils.getBeanGetValue(pagination));
			System.out.println(boardCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Sub List, Notice List, Board List, Pagination, BoardType (Sub, Sub1)
		if(pagination.getCurrentPage() <= 1 && pagination.getCt() == null){
			List<ArticleView> ntList = articleService.findNotices(pagination);
			modelAndView.addObject("noticeList", ntList);
		}
		if(pagination.getIsShare() == 1){
			List<BoardCodeView> boardCodeList = articleService.findBoards(null, BoardCode.BOARDCODE_COMPETITION);
			modelAndView.addObject("boardCodeList", boardCodeList);
		}
		
		modelAndView.addObject("isWrite", isWrite);
		modelAndView.addObject("boardList", avList);
		modelAndView.addObject("boardCount", boardCount);
		modelAndView.addObject("pagination", pagination);
		modelAndView.addObject("boardType", boardType);

		return modelAndView;
	}

	@RequestMapping(value = "/{boardType}/article/confirmpw.do", method = RequestMethod.GET)
	public ModelAndView confirmPwView(@PathVariable String boardType, @ModelAttribute("pagination") Pagination pagination, @RequestParam("ai") int articleId){
			ModelAndView modelAndView = new ModelAndView("/" + boardType	+ "/article/confirmpw");
			
			modelAndView.addObject("articleId", articleId);
			modelAndView.addObject("pagination", pagination);
			modelAndView.addObject("boardType", boardType);
			modelAndView.addObject("articleType", "confirmpw");
			return modelAndView;
	}
	
	// Article
	@RequestMapping("/{boardType}/article/read.do")
	public ModelAndView readArticle(@PathVariable String boardType,
			@RequestParam("ai") int articleId,
			@ModelAttribute("pagination") Pagination pagination, @RequestParam(value="password", required=false) String password)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView("/" + boardType
				+ "/article/read");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();	
		boolean isTeam = false;
		
		CommentView commentView = null;
		ArticleView articleView = articleService.getArticle(articleId);
		
		// 비밀번호 있을 경우,
		if(articleView.getPassword() != null && !articleView.getPassword().equals(password)){
			modelAndView.setViewName("redirect:" + "/" + boardType + "/board.do?bid=" 	+ pagination.getBoardCodeId());
			return modelAndView;
		}
		// 파일 관련
		List<FileView> articleFile = fileService.findFiles(articleView.getArticleId(), null, Article.IS_ARTICLE);
		List<FileView> fileList = new ArrayList<FileView>();
		
		if(pagination.getIsShare() == 0) {
			// 팀 내 파일 제출 시, 
			List<TeamCodeView> teamCodeList = teamService.findTeamCodes(pagination.getBoardCodeId(), auth.getName());
			
			if(teamCodeList != null && teamCodeList.size() > 0){
				TeamCodeView tcv = teamCodeList.get(0);
				fileList = fileService.findFiles(articleId, tcv.getTeamCodeId(), Article.IS_NOT_ARTICLE);
			}
		} else 
			fileList = fileService.findFiles(articleId, null,  Article.IS_NOT_ARTICLE);
		
		// 파일 내 태그 찾기
		for(FileView fv : fileList){
			int fileId = fv.getFileId();		
			fv.setTagList(tagService.findTags(fileId));
		}		
		
		
		// 조회 수 증가
		boolean isHit = articleService.increaseHit(articleView.getArticleId());
		
		// 해당 게시판의 팀원인지 아닌지 체크
		isTeam = teamService.containsTeam(auth.getName(), articleView.getBoardCodeId());
		// isTeam
		modelAndView.addObject("isTeam", isTeam);
		
		// Article
		modelAndView.addObject("article", articleView);
		// file List
		modelAndView.addObject("articleFile", articleFile);
		modelAndView.addObject("fileList", fileList);
		
		// parentBoardCodeId
		BoardCodeView boardCodeView = articleService.getBoard(articleView.getBoardCodeId());
		modelAndView.addObject("parentBoardCodeId", boardCodeView.getParentBoardCodeId());
		
		// Comment
		List<CommentView> commentList = commentService.findComments(articleId);
		// Write Comment 
		commentView = new CommentView();
		commentView.setArticleId(articleId);
		commentView.setWriterId(auth.getName());
		modelAndView.addObject("commentView", commentView);
		// Comment List, BoardType (Sub, Sub1),
		modelAndView.addObject("commentList", commentList);
		modelAndView.addObject("boardType", boardType);
		modelAndView.addObject("articleType", "read");

		return modelAndView;
	}
	
	@RequestMapping(value = "/{boardType}/article/uploadfile.do", method = RequestMethod.POST)
	public String readUploadFile(@PathVariable String boardType,
			@RequestParam("uploadfile") MultipartFile uploadFile, @RequestParam(value="tagName", required=false) List<String> tagNames, @ModelAttribute("pagination") Pagination pagination, @RequestParam("ai") int articleId){
			Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();	
			String userId = auth.getName();
			boolean chk = false;
			
			FileView fileView = FileUtils.getUploadFile(uploadFile, articleId, userId, Article.IS_NOT_ARTICLE); // 게시물의 파일들
			
			if(fileView != null){
				List<TeamCodeView> teamCodeList = teamService.findTeamCodes(pagination.getBoardCodeId(), auth.getName());
				TeamCodeView tcv = teamCodeList.get(0);
				List<FileView> fileList = fileService.findFiles(articleId, tcv.getTeamCodeId(), Article.IS_NOT_ARTICLE);
				
				// 팀 설정
				fileView.setTeamCodeId(tcv.getTeamCodeId());
				if(fileList != null){
					for(FileView fv : fileList)
						fileService.removeFile(fv.getFileId());
				}
				chk = fileService.addFile(fileView);
				
				// 태그 등록
				if(chk && tagNames != null){
					for(String tagName : tagNames){
						TagView tagView = new TagView();
						tagView.setFileId(fileView.getFileId());
						tagView.setTagName(tagName);
						tagService.addTag(tagView);
					}
				}
			}			
			return "redirect:" + "/" + boardType + "/article/read.do?" + pagination.toString() +  "&ai=" + articleId;
	}
	
	@RequestMapping(value = "/{boardType}/article/modifyShare.do", method = RequestMethod.GET)
	public String modifyShare(@PathVariable String boardType, @ModelAttribute("pagination") Pagination pagination, @RequestParam("ai") int articleId, @RequestParam("is") int isShare){
			articleService.modifyShare(isShare, articleId);
			
			return "redirect:" + "/" + boardType + "/article/read.do?bid=" + pagination.getBid() + "&sz=" + pagination.getPageSize() +  "&ai=" + articleId;
	}
	
	@RequestMapping(value = "/fileDown.do", method = RequestMethod.GET)
    public ModelAndView fileDown(@RequestParam("fi") int fileId) {
		FileView fileView = fileService.getFile(fileId);
	
        String fullPath = fileView.getFileUrl();
        File downloadFile = new File(fullPath);
        return new ModelAndView("download", "downloadFile", downloadFile);
    }	
	
	@RequestMapping(value = "/{boardType}/article/write.do", method = RequestMethod.GET)
	public ModelAndView writeViewArticle(@PathVariable String boardType,
			@RequestParam(value="ai", defaultValue="0") int articleId,
			@ModelAttribute("pagination") Pagination pagination) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/" + boardType
				+ "/article/write");
		ArticleView articleView = null;
		
		if(articleId == 0) {
			 articleView = new ArticleView();
		} else {
			articleView = articleService.getArticle(articleId);
		}
		articleView.setBoardCodeId(pagination.getBid());

		modelAndView.addObject("articleView", articleView);
		modelAndView.addObject("boardType", boardType);
		modelAndView.addObject("articleType", "write");
		return modelAndView;
	}

	@RequestMapping(value = "/{boardType}/article/write.do", method = RequestMethod.POST)
	public String writeArticle(@PathVariable String boardType,
			@ModelAttribute("articleView") @Valid ArticleView articleView)
			throws Exception {
		FileView fileView =  null;
		MultipartFile uploadfile = null;
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();	
		String userId = auth.getName();
		String authName = userService.getAuthName(userId);
		int authId = userService.getAuthId(authName);
		String message = "";
		boolean isArticle = false;
		
		// 파일 제출이 해당란이 없을 경우 - 전에 있던 해당 score_db에 있는 데이터를 없앤다.
		if(articleView.getArticleId() != Article.IS_NOT_MODIFY && !articleView.getIsFileView()){
			scoreService.removeScores(articleView.getArticleId());
		}
		
		if(articleView.getArticleId() == Article.IS_NOT_MODIFY){
			articleView.setWriterId(userId);
			articleView.setAuthId(authId);
			isArticle = articleService.addArticle(articleView);
		} else {	
			isArticle = articleService.modifyArticle(articleView);
		}
		uploadfile = articleView.getUploadfile();
		fileView = FileUtils.getUploadFile(uploadfile, articleView.getArticleId(), articleView.getWriterId(), Article.IS_ARTICLE); // 게시물의 파일들
		
		if(fileView != null){
			List<FileView> fileList = fileService.findFiles(articleView.getArticleId(), articleView.getWriterId(), Article.IS_ARTICLE);
			if(fileList != null){
				for(FileView fv : fileList)
					fileService.removeFile(fv.getFileId());
			}
			fileService.addFile(fileView);
		}
//		System.out.println(BeanUtils.getBeanGetValue(fileView));
		message = (isArticle) ? "success" : "fail";

		return "redirect:" + "/" + boardType + "/board.do?bid="
				+ articleView.getBoardCodeId() + "&message=" + message;
	}

	@RequestMapping("/{boardType}/article/remove.do")
	public String removeArticle(@PathVariable String boardType,
			@RequestParam("ai") int articleId,
			@ModelAttribute("pagination") Pagination pagination) {
		String message = "";
		boolean isArticle = false;

		isArticle = articleService.removeArticle(articleId);
		message = (isArticle) ? "success" : "fail";

		return "redirect:" + "/" + boardType + "/board.do?bid="
				+ pagination.getBid() + "&message=" + message;
	}
	
	@RequestMapping(value = "/{boardType}/article/addComment.do", method = RequestMethod.POST)
	public String addComment(@PathVariable String boardType,
			@ModelAttribute("pagination") Pagination pagination, @ModelAttribute("commentView") CommentView comment) throws Exception {
		String message = "";
		
		boolean isComment = commentService.addComment(comment);
		boolean isCommentCount = articleService.updownCommentCount(comment.getArticleId(), Comment.COMMENT_COUNT_UP);
				
		message = (isComment) ? "success" : "fail";
//		 bid=%d&sz=%d pg
		return "redirect:" + "/" + boardType + "/article/read.do?" + pagination.toString() + "&ai=" + comment.getArticleId() + "&message=" + message;
	}
	
	@RequestMapping(value = "/{boardType}/article/modifyComment.do", method = RequestMethod.POST)
	public String modifyComment(@PathVariable String boardType, @RequestParam("commentId") int commentId,  @ModelAttribute ContentView content,
			@ModelAttribute("pagination") Pagination pagination) throws Exception {
		String message = "";
		CommentView comment = commentService.getComment(commentId);
//		System.out.println(content);
		comment.setContent((content.getContent()));
		
		boolean isComment = commentService.modifyComment(comment);
		message = (isComment) ? "success" : "fail"; 
		return "redirect:" + "/" + boardType + "/article/read.do?" + pagination.toString() + "&ai=" + comment.getArticleId() + "&message=" + message;
	}
	
	@RequestMapping(value = "/{boardType}/article/removeComment.do", method = RequestMethod.GET)
	public String removeComment(@PathVariable String boardType, @RequestParam("cid") int commentId, @RequestParam("aid") int articleId,
			@ModelAttribute("pagination") Pagination pagination) throws Exception {
		String message = "";

		boolean isComment = commentService.removeComment(commentId);
		boolean isCommentCount = articleService.updownCommentCount(articleId, Comment.COMMENT_COUNT_DOWN);
		
		message = (isComment) ? "success" : "fail";
//		 bid=%d&sz=%d pg
		return "redirect:" + "/" + boardType + "/article/read.do?" + pagination.toString() + "&ai=" + articleId + "&message=" + message;
	}
}
