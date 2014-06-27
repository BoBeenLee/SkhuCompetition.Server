package competition.web.controller;

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
import competition.domain.code.BoardCode;
import competition.domain.code.TeamCode;
import competition.domain.list.ScoreList;
import competition.domain.list.TeamList;
import competition.domain.view.ScoreView;
import competition.domain.view.TeamView;
import competition.domain.view.ValuerView;
import competition.domain.view.code.BoardCodeView;
import competition.domain.view.code.TeamCodeView;
import competition.service.ArticleService;
import competition.service.ScoreService;
import competition.service.TeamService;
import competition.service.ValuerService;

@Controller
public class TeamController {
	@Autowired
	ArticleService articleService;
	@Autowired
	TeamService teamService;
	@Autowired
	ScoreService scoreService;
	@Autowired
	ValuerService valuerService;

	@ModelAttribute
	private void addModelData(HttpServletRequest request, Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		List<String> authNames = AuthUtils.getAuthNames(auth);
		List<Page> pgList = new ArrayList<Page>();
		String selectedURI = "";
		
		if(authNames.contains(Auth.ROLE_ADMIN) || authNames.contains(Auth.ROLE_PROFESOR)){
			pgList.add(new Page("팀관리", "team/managetm.do"));
			pgList.add(new Page("팀평가", "team/managesc.do"));
		} else if(authNames.contains(Auth.ROLE_STUDENT)){
			pgList.add(new Page("팀관리", "team/managetm.do"));
			pgList.add(new Page("팀신청", "team/addtm.do"));
		}
		
		// context 명 제외한 이후 경로 명 - 마이페이지 일 경우
		selectedURI = request.getRequestURI();
		selectedURI = selectedURI.substring(selectedURI.indexOf("/", selectedURI.indexOf("/") + 1) + 1);

		model.addAttribute("selectedURI", selectedURI);
		model.addAttribute("pgList", pgList);
	}
	
	// <!-- Team --> 보기 선택에서 시작하면 됨.
	@RequestMapping("/team/team.do")
	public ModelAndView viewTeam(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/team/team");

		modelAndView.addObject("subTitle", "팀페이지");
		modelAndView.addObject("teamType", "team");
		return modelAndView;
	}
	
	@RequestMapping(value = "/team/addtm.do", method = RequestMethod.GET)
	public ModelAndView viewAddTm(@RequestParam(value="tid", defaultValue="0") int teamCodeId) {
		ModelAndView modelAndView = new ModelAndView("/team/addtm");
		List<BoardCodeView> boardCodeList = articleService.findBoards(null, 2);
		TeamCodeView teamCodeView = null;
		List<TeamView> teamList = null;
		
		if(teamCodeId != 0)
			teamCodeView = teamService.getTeamCode(teamCodeId);
		else 
			teamCodeView = new TeamCodeView();		
		teamList = teamService.findTeams(teamCodeId);
		
		modelAndView.addObject("teamCodeView", teamCodeView);
		modelAndView.addObject("teamList", teamList);
		modelAndView.addObject("boardCodeList", boardCodeList);
		modelAndView.addObject("subTitle", "팀신청");
		modelAndView.addObject("teamType", "addtm");
		return modelAndView;
	}

	@RequestMapping(value = "/team/addtm.do", method = RequestMethod.POST)
	public String addTm(
			@ModelAttribute("teamCodeView") TeamCodeView teamCodeView,
			@RequestParam(value="teamList", required=false) Set<String> teamIdList) {
		String url = "redirect:" + "/team/addtm.do?message=addtm";
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		
		if(teamIdList == null)
			teamIdList = new HashSet<String>();
		// Add Leader
		teamIdList.add(auth.getName());
		
		// 조건 검색 부분 - 팀 생성 시 타팀에 중복된 사람이 있는 지
		if(teamCodeView.getTeamCodeId() == 0){
			for(String userId : teamIdList){
				if(teamService.containsTeam(userId, teamCodeView.getBoardCodeId()))
					return url + "&message=fail";
			}
		}
		// 조건 팀 권한에 맞는 사람이 수정하는 지
		if(teamCodeView.getTeamCodeId() != 0 && !auth.getName().equals(teamCodeView.getLeaderId()))
				return url + "&message=fail";		
		
		// 조건 만족 시 - 생성, 수정
		teamCodeView.setLeaderId(auth.getName());
		teamCodeView.setTeamType("A");
		
		if(teamCodeView.getTeamCodeId() != 0) {
			teamService.modifyTeamCode(teamCodeView);
			teamService.removeTeams(teamCodeView.getTeamCodeId());
		} else
			teamService.addTeamCode(teamCodeView);
		
		// Add Team 원
		for (String userId : teamIdList) {
			TeamView team = new TeamView();
			team.setTeamCodeId(teamCodeView.getTeamCodeId());
			team.setUserId(userId);
			try {
				System.out.println(BeanUtils.getBeanGetValue(team));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			teamService.addTeam(team);
		}
		return url;
	}

	@RequestMapping(value = "/team/managetm.do", method = RequestMethod.GET)
	public ModelAndView viewManagetm(
			@RequestParam(value = "bid", defaultValue = "0") int boardCodeId,
			@RequestParam(value = "tid", defaultValue = "0") int teamCodeId) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		ModelAndView modelAndView = new ModelAndView("/team/managetm");
		List<BoardCodeView> boardCodeList = null;
		List<String> authNames = AuthUtils.getAuthNames(auth);
		TeamList teamList = new TeamList();
		
//		권한에 따른 설정
		if(authNames.contains(Auth.ROLE_ADMIN)){
			boardCodeList = articleService.findBoards(null, 2);
		} else if(authNames.contains(Auth.ROLE_PROFESOR)) {
			List<ValuerView> vvList =  valuerService.findValuers(0, auth.getName());
			boardCodeList = new ArrayList<BoardCodeView>();
			for(ValuerView vv : vvList)
				boardCodeList.add(articleService.getBoard(vv.getBoardCodeId()));	
		} else {
			boardCodeList = new ArrayList<BoardCodeView>();
			List<BoardCodeView> tmpList = articleService.findBoards(null, 2); 
			for(BoardCodeView bcv : tmpList){
				if(teamService.containsTeam(auth.getName(), bcv.getBoardCodeId()))
					boardCodeList.add(bcv);
			}
		}
		
		if (boardCodeId != 0 && teamCodeId != 0) {
			TeamCodeView teamCodeView = teamService.getTeamCode(teamCodeId);
			List<TeamView> teams = teamService.findTeams(teamCodeId);
			teamList.setTeams(teams);
			teamList.setLeaderId(teamCodeView.getLeaderId());
			teamList.setIsPermission(teamCodeView.getIsPermission());
			teamList.setTeamCodeId(teamCodeId);
			teamList.setBoardCodeId(boardCodeId);
		}
		modelAndView.addObject("teamList", teamList);
		modelAndView.addObject("boardCodeList", boardCodeList);
		modelAndView.addObject("subTitle", "팀관리");
		modelAndView.addObject("teamType", "managetm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/team/managetm.do", method = RequestMethod.GET, params="cmd=pm")
	public String managetm(@RequestParam("pm") int isPermission, @RequestParam(value = "bid", defaultValue = "0") int boardCodeId, @RequestParam(value = "tid", defaultValue = "0") int teamCodeId) {
		TeamCodeView teamCodeView = teamService.getTeamCode(teamCodeId);
		if(isPermission == TeamCode.IS_PERMISSION)
			teamCodeView.setIsPermission(TeamCode.IS_PERMISSION);
		else
			teamCodeView.setIsPermission(TeamCode.IS_NOT_PERMISSION);
		teamService.modifyTeamCode(teamCodeView);
		
		return "redirect:" + "/team/managetm.do?bid="
				+ boardCodeId + "&tid=" + teamCodeId;
	}	
	
	@RequestMapping(value = "/team/removetm.do", method = RequestMethod.GET)
	public String removetm(@RequestParam(value = "tid", defaultValue = "0") int teamCodeId) {
		boolean isTeamCode = teamService.removeTeamCode(teamCodeId);
		
		return "redirect:" + "/team/managetm.do";
	}	
	
	@RequestMapping(value = "/team/managesc.do", method = RequestMethod.GET)
	public ModelAndView viewManagesc(
			@RequestParam(value = "bid", defaultValue = "0") int boardCodeId,
			@RequestParam(value = "tid", defaultValue = "0") int teamCodeId) {
		ModelAndView modelAndView = new ModelAndView("/team/managesc");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		List<String> authNames = AuthUtils.getAuthNames(auth);
		
		// 평가자인지 판단
		ValuerView valuerView = valuerService.getValuer(auth.getName(),
				boardCodeId);
		boolean isValuer = false;
		
		List<BoardCodeView> boardCodeList = new ArrayList<BoardCodeView>();
		List<Rank> rankList = teamService.findRanks(boardCodeId);
		ScoreList scoreList = new ScoreList();

		// 권한에 따른 설정
		if(authNames.contains(Auth.ROLE_ADMIN)){
			boardCodeList = articleService.findBoards(null, BoardCode.BOARDCODE_COMPETITION);
		} else if(authNames.contains(Auth.ROLE_PROFESOR)) {
			List<ValuerView> vvList =  valuerService.findValuers(0, auth.getName());
			boardCodeList = new ArrayList<BoardCodeView>();
			for(ValuerView vv : vvList)
				boardCodeList.add(articleService.getBoard(vv.getBoardCodeId()));	
		} 
		
		if(valuerView != null || authNames.contains(Auth.ROLE_ADMIN))
			isValuer = true;
		
		// 조회 했을 경우 데이터 불러옴.
		if (boardCodeId != 0 && teamCodeId != 0 && isValuer) {
			// admin 계정일 경우, 평가자일 경우 조회, 수정 가능
			scoreList.setScores(scoreService.findScores(boardCodeId, teamCodeId));
			scoreList.setBoardCodeId(boardCodeId);
			scoreList.setTeamCodeId(teamCodeId);
		}
		
		// Test
		try {
			System.out.println(BeanUtils.getBeanGetValue(valuerView));
		} catch(Exception e){}

		modelAndView.addObject("isValuer", isValuer);	
		modelAndView.addObject("scoreList", scoreList);
		modelAndView.addObject("rankList", rankList);
		modelAndView.addObject("boardCodeList", boardCodeList);
		modelAndView.addObject("subTitle", "점수관리");
		modelAndView.addObject("teamType", "managesc");
		return modelAndView;
	}

	@RequestMapping(value = "/team/managesc.do", method = RequestMethod.POST, params = "cmd=save")
	public String saveManagesc(@ModelAttribute("scoreList") ScoreList scoreList) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		ValuerView valuerView = valuerService.getValuer(auth.getName(),
				scoreList.getBoardCodeId());
		// admin 일 경우 
		if(valuerView == null)
			valuerView = new ValuerView();
		
		if (scoreList.getScores() != null) {
			for (ScoreView sv : scoreList.getScores()) {
				sv.setValuerId(valuerView.getValuerId());
				if (sv.getScoreId() == 0)
					scoreService.addScore(sv);
				else
					scoreService.modifyScore(sv);
			}
		}
		return "redirect:" + "/team/managesc.do?bid="
				+ scoreList.getBoardCodeId() + "&" + "tid=" + scoreList.getTeamCodeId();
	}

	@ResponseBody
	@RequestMapping(value = "/team/tclist.do", method = RequestMethod.GET)
	public List<TeamCodeView> tcList(
			@RequestParam(value = "bid", defaultValue = "0") int bid, @RequestParam(value = "ip", defaultValue = "0") int isPermission)
			throws Exception {
		List<TeamCodeView> teamCodeList = teamService.findTeamCodes(bid, null, isPermission);
		// 로그인 해야지 ajax가 반응이 옴.
		/*
		 * System.out.println("test"); for(TeamCodeView tcv : teamCodeList)
		 * System.out.println(BeanUtils.getBeanGetValue(tcv));
		 */
		return teamCodeList;
	}
}
