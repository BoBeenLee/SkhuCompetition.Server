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
import org.springframework.web.servlet.ModelAndView;

import util.AuthUtils;
import competition.domain.Article;
import competition.domain.Auth;
import competition.domain.Page;
import competition.domain.Rank;
import competition.domain.code.BoardCode;
import competition.domain.code.TeamCode;
import competition.domain.list.ScoreCodeList;
import competition.domain.view.ValuerView;
import competition.domain.view.code.BoardCodeView;
import competition.domain.view.code.ScoreCodeView;
import competition.domain.view.code.TeamCodeView;
import competition.service.ArticleService;
import competition.service.ScoreService;
import competition.service.TeamService;
import competition.service.ValuerService;

@Controller
public class CompetitionController {
	@Autowired
	ArticleService articleService;
	@Autowired
	ValuerService valuerService;
	@Autowired
	ScoreService scoreService;
	@Autowired
	TeamService teamService;
	
	@ModelAttribute
	private void addModelData(HttpServletRequest request, Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		List<String> authNames = AuthUtils.getAuthNames(auth);
		List<Page> pgList = new ArrayList<Page>();
		String selectedURI = "";
		
		pgList.addAll(articleService.getSubList(BoardCode.BOARDCODE_COMPETITION));
		
		// context 명 제외한 이후 경로 명
		selectedURI = request.getRequestURI();
		selectedURI = selectedURI.substring(selectedURI.indexOf("/", selectedURI.indexOf("/") + 1) + 1);
		
		model.addAttribute("selectedURI", selectedURI);		
		model.addAttribute("pgList", pgList);
	}
	
	//	Add Cpt
	@RequestMapping(value = "/competition/addcpt.do", method = RequestMethod.GET)
	public ModelAndView viewAddCpt() {
		ModelAndView modelAndView = new ModelAndView("/competition/addcpt");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		BoardCodeView boardCodeView = new BoardCodeView();
		List<String> authNames = AuthUtils.getAuthNames(auth);
		List<BoardCodeView> boardCodeList = null;
		
		//		권한에 따른 설정
		if(authNames.contains(Auth.ROLE_ADMIN)){
			boardCodeList = articleService.findBoards(Article.IS_NOT_ARTICLE, null, BoardCode.BOARDCODE_COMPETITION);
			boardCodeList.addAll(articleService.findBoards(Article.IS_HIDDEN, null, BoardCode.BOARDCODE_COMPETITION));	
		} else {
			boardCodeList = articleService.findBoards(Article.IS_NOT_ARTICLE, auth.getName(), BoardCode.BOARDCODE_COMPETITION);
			boardCodeList.addAll(articleService.findBoards(Article.IS_HIDDEN, auth.getName(), BoardCode.BOARDCODE_COMPETITION));
		}
		
		// Default Setting
		boardCodeView.setBuilderId(auth.getName());
		boardCodeView.setBoardType("A");
		boardCodeView.setIsHidden(0);
		boardCodeView.setParentBoardCodeId(2);

		modelAndView.addObject("boardCodeList", boardCodeList);
		modelAndView.addObject("boardCodeView", boardCodeView);
		modelAndView.addObject("subTitle", "대회신청");
		modelAndView.addObject("competitionType", "addcpt");
		return modelAndView;
	}

	@RequestMapping(value = "/competition/addcpt.do", method = RequestMethod.POST)
	public String addCpt(
			@ModelAttribute("BoardCodeView") BoardCodeView boardCodeView) {
		String message = "";
		boolean isBoardCode = articleService.addBoardCode(boardCodeView);

		if (isBoardCode)
			message = "addcpt";
		else
			message = "fail";

		return "redirect:" + "/competition/addcpt.do?message=" + message;
	}

	@RequestMapping(value = "/competition/hiddencpt.do", method = RequestMethod.POST)
	public String hiddenCpt(@RequestParam("boardCodeId") int boardCodeId,
			@RequestParam("isHidden") int isHidden) {
		String message = "";
		BoardCodeView boardCodeView = null;
		
		boardCodeView = articleService.getBoard(boardCodeId);
		boardCodeView.setIsHidden(isHidden);

		boolean isBoardCode = articleService.modifyBoardCode(boardCodeView);

		if (isBoardCode)
			message = "success";
		else
			message = "fail";
		return "redirect:" + "/competition/addcpt.do?message=" + message;
	}

	// Manage Competition
	@RequestMapping(value = "/competition/managecpt.do", method = RequestMethod.GET)
	public ModelAndView viewManagecpt(
			@RequestParam(value = "bid", defaultValue = "0") int boardCodeId) {
		ModelAndView modelAndView = new ModelAndView("/competition/managecpt");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		List<String> authNames = AuthUtils.getAuthNames(auth);
		List<BoardCodeView> boardCodeList = null;
		BoardCodeView boardCodeView = null;
		
		List<Rank> rankList = null;
		
		ScoreCodeList scoreCodeList = new ScoreCodeList();
		List<TeamCodeView> teamCodeList = null;
		List<ValuerView> valuerList = null;
		
		boolean isValuer = false;
		
		//	대회 관리는 누구에게나 보여주는 걸로
		boardCodeList = articleService.findBoards(null, 2);
		
		//		조회했을 경우
		if (boardCodeId != 0) {
			scoreCodeList.setBoardCodeId(boardCodeId);
			scoreCodeList.setScoreCodes(scoreService
					.findScoreCodes(boardCodeId));
			teamCodeList = teamService.findTeamCodes(boardCodeId, null, TeamCode.IS_PERMISSION);
			valuerList = valuerService.findValuers(boardCodeId, null);
			// isValuer
			if(valuerList != null){
				for(ValuerView vv : valuerList){
					if(vv.getUserId().equals(auth.getName())){
						isValuer = true;
						break;
					}
				}
			}
			boardCodeView = articleService.getBoard(boardCodeId);
		}		
		
		// Rank 
		rankList = teamService.findRanks(boardCodeId);
		
		modelAndView.addObject("isValuer", isValuer);
		modelAndView.addObject("valuerList", valuerList);
		modelAndView.addObject("rankList", rankList);
		modelAndView.addObject("teamCodeList", teamCodeList);
		modelAndView.addObject("scoreCodeList", scoreCodeList);
		modelAndView.addObject("boardCodeList", boardCodeList);
		modelAndView.addObject("boardCodeView", boardCodeView);
		modelAndView.addObject("subTitle", "대회관리");
		modelAndView.addObject("competitionType", "managecpt");
		return modelAndView;
	}
	
	//	ManageCpt
	@RequestMapping(value = "/competition/managecpt.do", method = RequestMethod.POST, params = "cmd=add")
	public String addManagecpt(
			@ModelAttribute("scoreCodeView") ScoreCodeView scoreCodeView) {
//		try {
//			System.out.println(BeanUtils.getBeanGetValue(scoreCodeView));
//		} catch(Exception e){ System.out.println(e); }
		scoreService.addScoreCode(scoreCodeView);
		return "redirect:" + "/competition/managecpt.do?bid="
				+ scoreCodeView.getBoardCodeId();
	}

	@RequestMapping(value = "/competition/managecpt.do", method = RequestMethod.POST, params = "cmd=modify")
	public String saveManagecpt(
			@ModelAttribute("scoreCodeList") ScoreCodeList scoreCodeList) {
		if (scoreCodeList != null) {
			for (ScoreCodeView scv : scoreCodeList.getScoreCodes()) {
				scoreService.modifyScoreCode(scv);
			}
		}
		return "redirect:" + "/competition/managecpt.do?bid="
				+ scoreCodeList.getBoardCodeId();
	}

	@RequestMapping(value = "/competition/managecpt.do", method = RequestMethod.GET, params = "cmd=remove")
	public String removeManagecpt(@RequestParam("bid") int boardCodeId,
			@RequestParam("scid") int scoreCodeId) {
		scoreService.removeScoreCode(scoreCodeId);
		return "redirect:" + "/competition/managecpt.do?bid=" + boardCodeId;
	}

	@RequestMapping(value = "/competition/managecpt.do", method = RequestMethod.GET, params = "cmd=name")
	public String saveBoardName(@RequestParam("bid") int boardCodeId, @RequestParam("boardName") String boardName){
		BoardCodeView boardCodeView = articleService.getBoard(boardCodeId);
		boardCodeView.setBoardName(boardName);
		articleService.modifyBoardCode(boardCodeView);
		return "redirect:" + "/competition/managecpt.do";
	}
	
	@RequestMapping(value = "/competition/savevaluer.do", method = RequestMethod.POST)
	public String saveValuer(@RequestParam("bid") int boardCodeId,
			@RequestParam(value="valuerList", required=false) Set<String> valuerList) {
		BoardCodeView boardCodeView = articleService.getBoard(boardCodeId);
		
		if(valuerList == null)
			valuerList = new HashSet<String>();
		// 대회 개설자 평가자로 등록
		valuerList.add(boardCodeView.getBuilderId());
		// 전에 있던 평가자들 삭제하고
		valuerService.removeValuers(boardCodeId);
		
		// 새로 다시 평가자들 등록
		for (String userId : valuerList) {
			ValuerView valuerView = valuerService
					.getValuer(userId, boardCodeId);
			if (valuerView == null) {
				valuerView = new ValuerView();
				valuerView.setBoardCodeId(boardCodeId);
				valuerView.setUserId(userId);
				valuerService.addValuer(valuerView);
			}
		}
		return "redirect:" + "/competition/managecpt.do?bid=" + boardCodeId;
	}
}
