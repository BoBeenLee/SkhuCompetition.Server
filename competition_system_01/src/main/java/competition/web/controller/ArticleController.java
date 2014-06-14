package competition.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import util.AuthUtils;
import util.BeanUtils;
import util.FileUtils;
import competition.domain.Article;
import competition.domain.Auth;
import competition.domain.Comment;
import competition.domain.Page;
import competition.domain.Pagination;
import competition.domain.code.BoardCode;
import competition.domain.view.ArticleView;
import competition.domain.view.AuthView;
import competition.domain.view.CommentView;
import competition.domain.view.FileView;
import competition.domain.view.code.BoardCodeView;
import competition.service.ArticleService;
import competition.service.CommentService;
import competition.service.FileService;
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

	@ModelAttribute
	private void addModelData(Model model, Pagination pagination) {
		if (pagination != null) {
			String subTitle = articleService.getBoardName(pagination.getBid());
			BoardCodeView bcv = articleService.getBoard(pagination.getBid());
			List<Page> pgList = new ArrayList<Page>();
			
			pgList.addAll(getSubList(bcv.getParentBoardCodeId()));
			// get Sub Boards
			if(bcv != null)
				pgList.addAll(articleService.getPageList(bcv.getParentBoardCodeId()));
			
			model.addAttribute("subTitle", subTitle);
			model.addAttribute("pgList", pgList);
		}
	}

	private List<Page> getSubList(int boardCodeId){
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		List<String> authNames = AuthUtils.getAuthNames(auth);
		List<Page> pgList = new ArrayList<Page>();
		
		if(BoardCode.BOARDCODE_COMPETITION == boardCodeId){
			if(authNames.contains(Auth.ROLE_ADMIN) || authNames.contains(Auth.ROLE_PROFESOR)){
				pgList.add(new Page("대회관리", "competition/managecpt.do"));
			} else if(authNames.contains(Auth.ROLE_STUDENT)){
				pgList.add(new Page("대회신청", "competition/addcpt.do"));
				pgList.add(new Page("대회관리", "competition/managecpt.do"));
			}
		}
		return pgList;
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
		
		modelAndView.addObject("isWrite", isWrite);
		modelAndView.addObject("boardList", avList);
		modelAndView.addObject("boardCount", boardCount);
		modelAndView.addObject("pagination", pagination);
		modelAndView.addObject("boardType", boardType);

		return modelAndView;
	}

	// Article
	@RequestMapping("/{boardType}/article/read.do")
	public ModelAndView readArticle(@PathVariable String boardType,
			@RequestParam("ai") int articleId,
			@ModelAttribute("pagination") Pagination pagination)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView("/" + boardType
				+ "/article/read");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();	
		boolean isTeam = false;
		
		CommentView commentView = null;
		ArticleView av = articleService.getArticle(articleId);
		List<FileView> aricleFile = fileService.findFiles(av.getArticleId(), null, Article.IS_ARTICLE);
		List<FileView> fileList = fileService.findFiles(articleId, auth.getName(), Article.IS_NOT_ARTICLE);
		
		// increase Hit
		boolean isHit = articleService.increaseHit(av.getArticleId());
		
		isTeam = teamService.containsTeam(auth.getName(), pagination.getBoardCodeId());
		// Test
//		System.out.println(BeanUtils.getBeanGetValue(av));
//		System.out.println(BeanUtils.getBeanGetValue(pagination));
		// isTeam
		modelAndView.addObject("isTeam", isTeam);
		// Article
		modelAndView.addObject("article", av);
		// file List
		modelAndView.addObject("articleFile", aricleFile);
		modelAndView.addObject("fileList", fileList);
		
		for(FileView fv : fileList)
			System.out.println(BeanUtils.getBeanGetValue(fv));
		
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
			@RequestParam("uploadfile") MultipartFile uploadFile, @ModelAttribute("pagination") Pagination pagination, @RequestParam("ai") int articleId){
			Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();	
			String userId = auth.getName();
			
			FileView fileView = FileUtils.getUploadFile(uploadFile, articleId, userId, Article.IS_NOT_ARTICLE); // 게시물의 파일들
			
			if(fileView != null){
				List<FileView> fileList = fileService.findFiles(articleId, userId, Article.IS_NOT_ARTICLE);
				
				if(fileList != null){
					for(FileView fv : fileList)
						fileService.removeFile(fv.getFileId());
				}
				fileService.addFile(fileView);
			}
			
			return "redirect:" + "/" + boardType + "/article/read.do?" + pagination.toString() +  "&ai=" + articleId;
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
			@ModelAttribute("articleView") ArticleView articleView)
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
	
		articleView.setWriterId(userId);
		articleView.setAuthId(authId);
		
//		System.out.println(articleView.getArticleId());
		if(articleView.getArticleId() == Article.IS_NOT_MODIFY)
			isArticle = articleService.addArticle(articleView);
		else 
			isArticle = articleService.modifyArticle(articleView);
		
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
	public String modifyComment(@PathVariable String boardType, @RequestParam("commentId") int commentId,  @RequestParam("content") String content,
			@ModelAttribute("pagination") Pagination pagination) throws Exception {
		String message = "";
		CommentView comment = commentService.getComment(commentId);
		
		comment.setContentView(content);
		
		boolean isComment = commentService.modifyComment(comment);
		
		message = (isComment) ? "success" : "fail";
//		 bid=%d&sz=%d pg
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
