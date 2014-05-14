package competition.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataController {
	@RequestMapping("data.do")
	public ModelAndView getCompetitionBoard(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/sub/board"); 
		
		return modelAndView;
	}
}
