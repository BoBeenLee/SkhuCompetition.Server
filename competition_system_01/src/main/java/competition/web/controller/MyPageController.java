package competition.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import util.AuthUtils;
import util.BeanUtils;
import competition.domain.Article;
import competition.domain.Auth;
import competition.domain.Comment;
import competition.domain.Page;
import competition.domain.Pagination;
import competition.domain.list.MailList;
import competition.domain.view.CommentView;
import competition.domain.view.ContentView;
import competition.domain.view.MailView;
import competition.domain.view.TagView;
import competition.domain.view.TeamView;
import competition.domain.view.UserView;
import competition.domain.view.code.BoardCodeView;
import competition.domain.view.code.TeamCodeView;
import competition.service.ArticleService;
import competition.service.CommentService;
import competition.service.MailService;
import competition.service.TagService;
import competition.service.TeamService;
import competition.service.UserService;

@Controller
public class MyPageController {
	@Autowired
	ArticleService articleService;	
	@Autowired
	UserService userService;
	@Autowired
	CommentService commentService;
	@Autowired
	TagService tagService;
	@Autowired
	TeamService teamService;
	@Autowired
	MailService mailService;

	@ModelAttribute
	private void addModelData(@RequestParam(value="cmd", required=false) String cmd, HttpServletRequest request, Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		List<String> authNames = AuthUtils.getAuthNames(auth);
		final String myPath = "mypage/";
		final String mailPath = "mail/";
		List<Page> pgList = new ArrayList<Page>();
		String selectedURI = "";
		
		if(authNames.contains(Auth.ROLE_ADMIN) || authNames.contains(Auth.ROLE_PROFESOR)){
			pgList.add(new Page("회원정보 수정", myPath + "modify.do?cmd=chkpw"));
			pgList.add(new Page("비밀번호 변경", myPath + "changepw.do"));
			pgList.add(new Page("회원탈퇴", myPath + "withdraw.do"));
			pgList.add(new Page("메일보내기", mailPath + "send.do"));
			if(authNames.contains(Auth.ROLE_ADMIN)){
				pgList.add(new Page("덧글관리", myPath + "managecmt.do?bid=0"));
				pgList.add(new Page("태그관리", myPath + "managetag.do"));
			}
			if(authNames.contains(Auth.ROLE_ADMIN) && auth.getName().equals("admin")){
				pgList.add(new Page("관리자권한 부여", myPath + "grantadmin.do"));
			}
		} else if(authNames.contains(Auth.ROLE_STUDENT) || authNames.contains(Auth.ROLE_USER)){
			pgList.add(new Page("회원정보 수정", myPath + "modify.do?cmd=chkpw"));
			pgList.add(new Page("비밀번호 변경", myPath + "changepw.do"));
			pgList.add(new Page("회원탈퇴", myPath + "withdraw.do"));
		}
		
		// context 명 제외한 이후 경로 명 - 마이페이지 일 경우
		selectedURI = request.getRequestURI();
		selectedURI = selectedURI.substring(selectedURI.indexOf("/", selectedURI.indexOf("/") + 1) + 1);
		if(cmd != null)
			selectedURI = selectedURI + "?cmd=" + cmd;
		
//		System.out.println(selectedURI);
		model.addAttribute("selectedURI", selectedURI);
		model.addAttribute("pgList", pgList);
	}

	@RequestMapping(value = "/mypage/modify.do", method = RequestMethod.GET, params = "cmd=chkpw")
	public ModelAndView viewChkPw() throws Exception {
		ModelAndView modelAndView = new ModelAndView("/mypage/modify");

		modelAndView.addObject("subTitle", "회원확인");
		modelAndView.addObject("mypageType", "chkpw");
		return modelAndView;
	}

	@RequestMapping(value = "/mypage/modify.do", method = RequestMethod.POST, params = "cmd=modify")
	public ModelAndView viewModify(@RequestParam("userPW") String userPW)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView("/mypage/modify");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		
		UserView userView = userService.getUser(auth.getName(), userPW);

		// 비밀번호 틀렸을 경우
		if(userView == null){
			modelAndView.setViewName("redirect:/mypage/modify.do?cmd=chkpw");
			return modelAndView;
		}
		
		modelAndView.addObject("userView", userView);
		modelAndView.addObject("subTitle", "회원수정");
		modelAndView.addObject("mypageType", "modify");
		return modelAndView;
	}

	@RequestMapping(value = "/mypage/modify.do", method = RequestMethod.POST)
	public String modify(@ModelAttribute("userView") UserView userView)
			throws Exception {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String url = "";
		boolean isUser = false;

		userView.setUserId(auth.getName());

		isUser = userService.modifyUser(userView);

		if (isUser)
			url = "redirect:" + "/main/main.do?message=modify";
		else
			url = "redirect:" + "/main/main.do?message=fail";
		return url;
	}

	@RequestMapping(value = "/mypage/changepw.do", method = RequestMethod.GET)
	public ModelAndView viewChangePW() {
		ModelAndView modelAndView = new ModelAndView("/mypage/changepw");

		modelAndView.addObject("subTitle", "비밀번호변경");
		modelAndView.addObject("mypageType", "changepw");
		return modelAndView;
	}

	@RequestMapping(value = "/mypage/changepw.do", method = RequestMethod.POST)
	public String changePW(@RequestParam("preUserPW") String preUserPW,
			@RequestParam("userPW") String userPW) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userId = auth.getName();
		String url = "";
		boolean isUser = false;

		isUser = userService.changePW(userId, preUserPW, userPW);

		if (isUser)
			url = "redirect:" + "/main/main.do?message=changepw";
		else
			url = "redirect:" + "/main/main.do?message=fail";
		return url;
	}

	@RequestMapping(value = "/mypage/withdraw.do", method = RequestMethod.GET)
	public ModelAndView viewWithdraw() {
		ModelAndView modelAndView = new ModelAndView("/mypage/withdraw");

		modelAndView.addObject("subTitle", "회원탈퇴");
		modelAndView.addObject("mypageType", "withdraw");
		return modelAndView;
	}

	@RequestMapping(value = "/mypage/withdraw.do", method = RequestMethod.POST)
	public String withdraw(@RequestParam("userPW") String userPW) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userId = auth.getName(); // get logged in userId
		String url = "";

		boolean isUser = userService.removeUser(userId, userPW);

		if (isUser)
			url = "redirect:" + "/logout.do";
		else
			url = "redirect:" + "/main/main.do?message=fail";
		return url;
	}
	
	@RequestMapping(value = "/mypage/grantadmin.do", method = RequestMethod.GET)
	public ModelAndView viewGrantAdmin(){
		ModelAndView modelAndView = new ModelAndView("/mypage/grantadmin");
		Pagination pagination = new Pagination();
		
		pagination.setSrchType("authName");
		pagination.setContent(Auth.ROLE_ADMIN);
		
		List<UserView> userList = userService.findUsers(pagination);
		
		modelAndView.addObject("userList", userList);
		modelAndView.addObject("subTitle", "관리자권한 부여");
		modelAndView.addObject("mypageType", "grantadmin");
		return modelAndView;
	}
	
	@RequestMapping(value = "/mypage/grantadmin.do", method = RequestMethod.POST)
	public String grantAdmin(@RequestParam("userList") List<String> userList){
		
		for(String userId : userList){
			UserView user = new UserView();
			user.setUserId(userId);
			user.setAuthName(Auth.ROLE_ADMIN);
			userService.grantAuth(user);
		}
		return "redirect:" + "/mypage/grantadmin.do";
	}
	
	@RequestMapping(value = "/mypage/returnauth.do")
	public String grantAdmin(@RequestParam("ui") String userId){
		userService.returnAuth(userId);
		return "redirect:" + "/mypage/grantadmin.do";
	}
	
	// Common
	@RequestMapping(value = "/mail/send.do")
	public ModelAndView viewSendMail(
			@RequestParam(value = "userId", required = false) List<String> userIds,
			@RequestParam(value = "bid", defaultValue = "0") int boardCodeId) {
		ModelAndView modelAndView = new ModelAndView("/mail/send");
		List<MailView> mails = new ArrayList<MailView>();
		MailList mailList = new MailList();
		List<TeamCodeView> teamCodeList = null;
		
//		한 경진대회 참가자들에게 메시지 보내기
		if (boardCodeId != 0) {
			teamCodeList = teamService.findTeamCodes(boardCodeId, null);
			for (TeamCodeView tcv : teamCodeList) {
				List<TeamView> teamList = teamService.findTeams(tcv
						.getTeamCodeId());
				for (TeamView tv : teamList) {
					MailView mv = mailService.getEmail(tv.getUserId(), null, null);
					if (mv != null)
						mails.add(mv);
				}
			}
		}
//		선택한 참가자들에게 메시지 보내기
		if (userIds != null) {
			for (String userId : userIds) {
				MailView mv = mailService.getEmail(userId, null, null);
				if (mv != null)
					mails.add(mv);
			}
		}
		mailList.setMails(mails);
		modelAndView.addObject("mailList", mailList);
		modelAndView.addObject("subTitle", "메일보내기");
		modelAndView.addObject("mypageType", "send");
		return modelAndView;
	}

	@RequestMapping(value = "/mypage/managecmt.do", method = RequestMethod.GET)
	public ModelAndView viewManagecmt(@RequestParam(value="bid", defaultValue="0") int boardCodeId) {
		ModelAndView modelAndView = new ModelAndView("/mypage/managecmt");
		List<CommentView> commentList;
		
		// 보드가 0일 경우는 대회 자료 공유임.
		if(boardCodeId != 0)
			commentList = commentService.findBoardComments(boardCodeId, Article.IS_NOT_SHARE);
		else
			commentList = commentService.findBoardComments(boardCodeId, Article.IS_SHARE);
		
		List<BoardCodeView> boardCodeList = articleService.findBoards(null, 0);
		
		modelAndView.addObject("boardCodeList", boardCodeList);
		modelAndView.addObject("commentList", commentList);
		modelAndView.addObject("subTitle", "덧글 관리");
		modelAndView.addObject("mypageType", "managecmt");
		return modelAndView;
	}

	@RequestMapping(value = "/mypage/managecmt.do", method = RequestMethod.POST, params="cmd=modify")
	public String modifyComment(@RequestParam("bid") int boardCodeId, @RequestParam("commentId") int commentId,  @ModelAttribute ContentView content) throws Exception {
		String message = "";
		CommentView comment = commentService.getComment(commentId);
//		System.out.println(content);
		comment.setContent((content.getContent()));
		
		boolean isComment = commentService.modifyComment(comment);
		message = (isComment) ? "success" : "fail"; 
		return "redirect:/mypage/managecmt.do?bid=" + boardCodeId;
	}
	
	@RequestMapping(value = "/mypage/managecmt.do", method = RequestMethod.GET, params="cmd=remove")
	public String removeComment(@RequestParam("bid") int boardCodeId, @RequestParam("cid") int commentId, @RequestParam("aid") int articleId) throws Exception {
		String message = "";

		boolean isComment = commentService.removeComment(commentId);
		boolean isCommentCount = articleService.updownCommentCount(articleId, Comment.COMMENT_COUNT_DOWN);
		
		message = (isComment) ? "success" : "fail";
//		 bid=%d&sz=%d pg
		return "redirect:/mypage/managecmt.do?bid=" + boardCodeId;
	}
	
	@RequestMapping(value = "/mypage/managetag.do", method = RequestMethod.GET)
	public ModelAndView viewManagetag(@RequestParam(value="tn", required=false) String tagName) {
		ModelAndView modelAndView = new ModelAndView("/mypage/managetag");
		
		List<TagView> tagTypeList = tagService.findTagTypes();
		List<TagView> tagList = null;
		if(tagName != null){
			tagList = tagService.findTags(tagName);
		}
		modelAndView.addObject("tagTypeList", tagTypeList);
		modelAndView.addObject("tagList", tagList);
		modelAndView.addObject("subTitle", "태그관리");
		modelAndView.addObject("mypageType", "managetag");
		return modelAndView;
	}
	
	@RequestMapping(value = "/mypage/modifytag.do", method = RequestMethod.GET)
	public String modifyTag(@RequestParam(value="tn", required=false) String tn, @RequestParam("tagId") int tagId, @RequestParam("tagName") String tagName){
		TagView tagView = tagService.getTag(tagId);
		tagView.setTagName(tagName);
		boolean isTag = tagService.modifyTag(tagView);
		
		return "redirect:/mypage/managetag.do?tn=" + tn;
	}
	
	@RequestMapping(value = "/mypage/removetag.do", method = RequestMethod.GET)
	public String removeTag(@RequestParam(value="tn", required=false) String tn, @RequestParam("tid") int tagId){
		boolean isTag = tagService.removeTag(tagId);
		
		return "redirect:/mypage/managetag.do?tn=" + tn;
	}
	
	@RequestMapping(value = "/mail/sendMail.do")
	public String sendMail(@RequestParam("mailList") List<String> userIds, @RequestParam(value="title", required=false) String title, @RequestParam(value="content", required=false) String content) {
		if(userIds != null){
			for(String userId : userIds){
				MailView mv = mailService.getEmail(userId, null, null);
				// Send a composed mail
				mailService.sendMail(mv.getToMail(), title, content);
			}
		}
		return "redirect:" + "/mail/send.do";
	}
}
