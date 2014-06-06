package competition.web.controller;

import java.text.ParseException;
import java.util.ArrayList;
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

import util.BeanUtils;

import competition.domain.Page;
import competition.domain.Rank;
import competition.domain.Team;
import competition.domain.list.ScoreList;
import competition.domain.view.CalendarView;
import competition.domain.view.ScoreView;
import competition.domain.view.UserView;
import competition.domain.view.ValuerView;
import competition.domain.view.code.BoardCodeView;
import competition.domain.view.code.ScoreCodeView;
import competition.domain.view.code.TeamCodeView;
import competition.service.ArticleService;
import competition.service.CalendarService;
import competition.service.ScoreService;
import competition.service.TeamService;
import competition.service.UserService;
import competition.service.ValuerService;

@Controller
public class MyPageController {
	public static final List<Page> pgList;

	static {
		String urlPath = "mypage/";
		pgList = new ArrayList<Page>();

		pgList.add(new Page("대회신청", urlPath + "addcpt.do"));
		pgList.add(new Page("팀신청", urlPath + "addtm.do"));
		pgList.add(new Page("팀관리", urlPath + "managetm.do"));
		pgList.add(new Page("대회관리", urlPath + "managecpt.do"));
		pgList.add(new Page("점수관리", urlPath + "managesc.do"));
		pgList.add(new Page("비밀번호변경", urlPath + "changepw.do"));
		pgList.add(new Page("회원수정", urlPath + "modify.do?cmd=chkpw"));
		pgList.add(new Page("회원탈퇴", urlPath + "withdraw.do"));
		pgList.add(new Page("달력관리", urlPath + "managecal.do"));
	}

	@Autowired
	UserService userService;
	@Autowired
	ArticleService articleService;
	@Autowired
	TeamService teamService;
	@Autowired
	ScoreService scoreService;
	@Autowired
	ValuerService valuerService;
	@Autowired
	CalendarService calendarService;
	
	
	@ModelAttribute
	private void addModelData(Model model) {
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

	@RequestMapping(value = "/mypage/addcpt.do", method = RequestMethod.GET)
	public ModelAndView viewAddCpt() {
		ModelAndView modelAndView = new ModelAndView("/mypage/addcpt");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		BoardCodeView boardCodeView = new BoardCodeView();
		
		List<BoardCodeView> boardCodeList = articleService.findBoards(auth.getName(), 0);
		
//		 Default Setting
		boardCodeView.setBuilderId(auth.getName());
		boardCodeView.setBoardType("A");
		boardCodeView.setIsHidden(0);
		boardCodeView.setParentBoardCodeId(2);
		
		modelAndView.addObject("boardCodeList", boardCodeList);
		modelAndView.addObject("boardCodeView", boardCodeView);
		modelAndView.addObject("subTitle", "대회신청");
		modelAndView.addObject("mypageType", "addcpt");
		return modelAndView;
	}

	@RequestMapping(value = "/mypage/addcpt.do", method = RequestMethod.POST)
	public String addCpt(@ModelAttribute("BoardCodeView") BoardCodeView boardCodeView) {
		String message = "";
		boolean isBoardCode = articleService.addBoardCode(boardCodeView);
		
		if(isBoardCode)
			message = "addcpt";
		else
			message = "fail";
		
		return  "redirect:" + "/mypage/addcpt.do?message=" + message;
	}
	
	@RequestMapping(value = "/mypage/hiddencpt.do", method = RequestMethod.POST)
	public String hiddencpt(@RequestParam("boardCodeId") int boardCodeId, @RequestParam("isHidden") int isHidden) {
		String message = "";
		BoardCodeView boardCodeView = articleService.getBoard(boardCodeId);
		boardCodeView.setIsHidden(isHidden);
		
		boolean isBoardCode = articleService.modifyBoardCode(boardCodeView);
		
		if(isBoardCode)
			message = "success";
		else 
			message = "fail";
		
		return  "redirect:" + "/mypage/addcpt.do?message=" + message;
	}
	
	@RequestMapping(value = "/mypage/addtm.do", method = RequestMethod.GET)
	public ModelAndView viewAddTm() {
		ModelAndView modelAndView = new ModelAndView("/mypage/addtm");
		List<BoardCodeView> boardCodeList = articleService.findBoards(null, 2);

		modelAndView.addObject("boardCodeList", boardCodeList);
		modelAndView.addObject("subTitle", "팀신청");
		modelAndView.addObject("mypageType", "addtm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/mypage/addtm.do", method = RequestMethod.POST)
	public String addTm(@ModelAttribute("teamCodeView") TeamCodeView teamCodeView, @RequestParam("teamList") Set<String> teamIdList) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		
		teamCodeView.setLeaderId(auth.getName());
		teamCodeView.setTeamType("A");
		teamService.addTeamCode(teamCodeView);
		
//		Add Leader 
		teamIdList.add(teamCodeView.getLeaderId());
//		Add Team 원
		for(String teamId : teamIdList) {
			Team team = new Team();
			team.setUserId(teamId);
			team.setTeamCodeId(teamCodeView.getTeamCodeId());
			teamService.addTeam(team);
		}
		
		return "redirect:" + "/mypage/addtm.do?message=addtm";
	}

	@RequestMapping(value = "/mypage/managesc.do", method = RequestMethod.GET)
	public ModelAndView viewManagesc(@RequestParam(value="bid", defaultValue="0") int boardCodeId, @RequestParam(value="tid", defaultValue="0") int teamCodeId) {
		ModelAndView modelAndView = new ModelAndView("/mypage/managesc");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		ValuerView valuerView = valuerService.getValuer(auth.getName(), boardCodeId);
		List<BoardCodeView> boardCodeList = articleService.findBoards(null, 2);
		List<Rank> rankList = teamService.findRanks(boardCodeId);
		ScoreList scoreList = new ScoreList(); 
		
		if(boardCodeId != 0 && teamCodeId != 0){
//			System.out.println(boardCodeId + " - " + valuerView.getValuerId() + " - " + teamCodeId);
			scoreList.setScores(scoreService.findScores(boardCodeId, valuerView.getValuerId(), teamCodeId));
			scoreList.setBoardCodeId(boardCodeId);
			scoreList.setTeamCodeId(teamCodeId);
		}
		modelAndView.addObject("scoreList", scoreList);
		modelAndView.addObject("rankList", rankList);
		modelAndView.addObject("boardCodeList", boardCodeList);
		modelAndView.addObject("subTitle", "점수관리");
		modelAndView.addObject("mypageType", "managesc");
		return modelAndView;
	}
	
	@RequestMapping(value = "/mypage/managesc.do", method = RequestMethod.POST, params="cmd=save")
	public String saveManagesc(@ModelAttribute("scoreList") ScoreList scoreList) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		ValuerView valuerView = valuerService.getValuer(auth.getName(), scoreList.getBoardCodeId());
		
		if(scoreList.getScores() != null){
			for(ScoreView sv : scoreList.getScores()){
				sv.setValuerId(valuerView.getValuerId());
				
				if(sv.getScoreId() == 0)
					scoreService.addScore(sv);
				else 
					scoreService.modifyScore(sv);
			}
		}
		return "redirect:" + "/mypage/managesc.do";
	}
	
	@ResponseBody
	@RequestMapping("/mypage/tclist.do")
	public List<TeamCodeView> tcList(@RequestParam("bid") int bid) throws Exception {
		List<TeamCodeView> teamCodeList = teamService.findTeamCodes(bid);		
		return teamCodeList;
	}

	@RequestMapping(value = "/mypage/managetm.do", method = RequestMethod.GET)
	public ModelAndView viewManagetm() {
		ModelAndView modelAndView = new ModelAndView("/mypage/managetm");

		modelAndView.addObject("subTitle", "팀관리");
		modelAndView.addObject("mypageType", "managetm");
		return modelAndView;
	}

	@RequestMapping(value = "/mypage/managecpt.do", method = RequestMethod.GET)
	public ModelAndView viewManagecpt(@RequestParam(value="bid", defaultValue="0") int boardCodeId) {
		ModelAndView modelAndView = new ModelAndView("/mypage/managecpt");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		List<BoardCodeView> boardCodeList = articleService.findBoards(auth.getName(), 2);
		List<ScoreCodeView> scoreCodeList = null;
		
		if(boardCodeId != 0){
			scoreCodeList = scoreService.findScoreCodes(boardCodeId);
		}
		
		modelAndView.addObject("scoreCodeList", scoreCodeList);
		modelAndView.addObject("boardCodeList", boardCodeList);
		modelAndView.addObject("subTitle", "대회관리");
		modelAndView.addObject("mypageType", "managecpt");
		return modelAndView;
	}

	
	@RequestMapping(value = "/mypage/saveValuer.do", method = RequestMethod.POST)
	public ModelAndView saveValuer(@RequestParam("valuerList") List<String> valuerList) {
		ModelAndView modelAndView = new ModelAndView("/mypage/managecpt");

		for(String item : valuerList)
			System.out.println(item);
		
		modelAndView.addObject("subTitle", "대회관리");
		modelAndView.addObject("mypageType", "managecpt");
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

	@RequestMapping(value = "/mypage/managecal.do", method = RequestMethod.GET)
	public ModelAndView viewManageCal(
			@ModelAttribute("calendarView1") CalendarView calendarView1) {
		ModelAndView modelAndView = new ModelAndView("/mypage/managecal");
		List<CalendarView> calendarList = null;

		if (calendarView1 != null) {
			calendarList = calendarService.findCalendars(
					calendarView1.getStartDate(), calendarView1.getEndDate());
		} else
			calendarView1 = new CalendarView();

		modelAndView.addObject("calendarList", calendarList);
		modelAndView.addObject("calendarView2", new CalendarView());
		modelAndView.addObject("subTitle", "달력관리");
		modelAndView.addObject("mypageType", "managecal");
		return modelAndView;
	}

	@RequestMapping(value = "/mypage/addCalendar.do", method = RequestMethod.POST)
	public ModelAndView addCalendar(@RequestParam("sd") String startDateView,
			@RequestParam("ed") String endDateView,
			@ModelAttribute("calendarView2") CalendarView calendarView2)
			throws ParseException {
		ModelAndView modelAndView = new ModelAndView("/mypage/managecal");
		boolean isCalendar = calendarService.addCalendar(calendarView2);
		List<CalendarView> calendarList = null;
		CalendarView calendarView1 = new CalendarView();

		calendarView1.setStartDateView(startDateView);
		calendarView1.setEndDateView(endDateView);

		calendarList = calendarService.findCalendars(
				calendarView1.getStartDate(), calendarView1.getEndDate());

		calendarView2 = new CalendarView();
		modelAndView.addObject("calendarList", calendarList);
		modelAndView.addObject("calendarView1", calendarView1);
		modelAndView.addObject("subTitle", "달력관리");
		modelAndView.addObject("mypageType", "managecal");
		return modelAndView;
	}

	@RequestMapping(value = "/mypage/removeCalendar.do", method = RequestMethod.GET)
	public ModelAndView removeCalendar(@RequestParam("cId") int calendarId,
			@ModelAttribute("calendarView1") CalendarView calendarView1) {
		ModelAndView modelAndView = new ModelAndView("/mypage/managecal");
		boolean isCalendar = calendarService.removeCalendar(calendarId);
		List<CalendarView> calendarList = null;
		
		if (calendarView1 != null) {
			calendarList = calendarService.findCalendars(
					calendarView1.getStartDate(), calendarView1.getEndDate());
		} else
			calendarView1 = new CalendarView();

		modelAndView.addObject("calendarList", calendarList);
		modelAndView.addObject("calendarView2", new CalendarView());
		modelAndView.addObject("subTitle", "달력관리");
		modelAndView.addObject("mypageType", "managecal");
		return modelAndView;
	}
	
//	 Common
	
}
