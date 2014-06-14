package competition.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import competition.domain.Pagination;
import competition.domain.view.UserView;
import competition.domain.view.code.TeamCodeView;
import competition.service.TeamService;
import competition.service.UserService;

@Controller
public class PopupController {
	@Autowired
	UserService userService;
	@Autowired
	TeamService teamService;
	
	@RequestMapping(value = "/popup/findUsers.do", method = RequestMethod.GET)
	public ModelAndView findUsers(@ModelAttribute("pagination") Pagination pagination) {
		ModelAndView modelAndView = new ModelAndView("/popup/findUsers");
		List<UserView> userList = null;
		
		if(pagination.getSrchType() != null)
			userList = userService.findUsers(pagination);
		
		modelAndView.addObject("userList", userList);
		modelAndView.addObject("subTitle", "유저검색");
		modelAndView.addObject("popupType", "findUsers");
		return modelAndView;
	}
	
	@RequestMapping(value = "/popup/findTeams.do", method = RequestMethod.GET)
	public ModelAndView findTeams(@RequestParam("bid") int boardCodeId, @ModelAttribute("pagination") Pagination pagination) {
		ModelAndView modelAndView = new ModelAndView("/popup/findTeams");
		List<TeamCodeView> teamCodeList = teamService.findTeamCodes(boardCodeId, null);

		modelAndView.addObject("teamCodeList", teamCodeList);
		modelAndView.addObject("subTitle", "팀검색");
		modelAndView.addObject("popupType", "findTeams"); 
		return modelAndView;
	}
	
	
}
