package competition.web.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import util.AuthUtils;
import util.BeanUtils;
import competition.domain.Auth;
import competition.domain.Page;
import competition.domain.Rank;
import competition.domain.Team;
import competition.domain.code.TeamCode;
import competition.domain.list.MailList;
import competition.domain.list.ScoreCodeList;
import competition.domain.list.ScoreList;
import competition.domain.list.TeamList;
import competition.domain.view.CalendarView;
import competition.domain.view.MailView;
import competition.domain.view.ScoreView;
import competition.domain.view.TeamView;
import competition.domain.view.UserView;
import competition.domain.view.ValuerView;
import competition.domain.view.code.BoardCodeView;
import competition.domain.view.code.ScoreCodeView;
import competition.domain.view.code.TeamCodeView;
import competition.service.ArticleService;
import competition.service.CalendarService;
import competition.service.MailService;
import competition.service.ScoreService;
import competition.service.TeamService;
import competition.service.UserService;
import competition.service.ValuerService;

@Controller
public class MyPageController {
	@Autowired
	UserService userService;
	@Autowired
	TeamService teamService;
	@Autowired
	MailService mailService;

	@ModelAttribute
	private void addModelData(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		List<String> authNames = AuthUtils.getAuthNames(auth);
		final String myPath = "mypage/";
		final String mailPath = "mail/";
		List<Page> pgList = new ArrayList<Page>();
		
		if(authNames.contains(Auth.ROLE_ADMIN) || authNames.contains(Auth.ROLE_PROFESOR)){
			pgList.add(new Page("회원수정", myPath + "modify.do?cmd=chkpw"));
			pgList.add(new Page("비밀번호변경", myPath + "changepw.do"));
			pgList.add(new Page("회원탈퇴", myPath + "withdraw.do"));
			pgList.add(new Page("메일보내기", mailPath + "send.do"));
		} else if(authNames.contains(Auth.ROLE_STUDENT)){
			pgList.add(new Page("회원수정", myPath + "modify.do?cmd=chkpw"));
			pgList.add(new Page("비밀번호변경", myPath + "changepw.do"));
			pgList.add(new Page("회원탈퇴", myPath + "withdraw.do"));
		}
		
		model.addAttribute("pgList", pgList);
	}

	// <!-- Mypage --> 보기 선택에서 시작하면 됨.
	@RequestMapping("/mypage/mypage.do")
	public ModelAndView viewMypage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/mypage/mypage");

		modelAndView.addObject("subTitle", "마이페이지");
		modelAndView.addObject("mypageType", "mypage");
		return modelAndView;
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

		BeanUtils.getBeanGetValue(userView);
		isUser = userService.modifyUser(userView);

		if (isUser)
			url = "redirect:" + "/index.do?message=modify";
		else
			url = "redirect:" + "/index.do?message=fail";
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
			url = "redirect:" + "/index.do?message=changepw";
		else
			url = "redirect:" + "/index.do?message=fail";
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
			url = "redirect:" + "/index.do?message=withdraw";
		else
			url = "redirect:" + "/index.do?message=fail";
		return url;
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

	@RequestMapping(value = "/mail/sendMail.do")
	public String sendMail(@ModelAttribute("mailList") MailList mailList) {

		for (MailView mv : mailList.getMails()) {
			// Send a composed mail
			mailService
					.sendMail(mv.getToMail(), "Test Subject", "Testing body");
		}
		return "redirect:" + "/mail/send.do";
	}
}
