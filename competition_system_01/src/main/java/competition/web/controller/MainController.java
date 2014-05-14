package competition.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import competition.service.ArticleService;
import competition.service.CalendarService;


@Controller
public class MainController {

	@Autowired
	CalendarService calendarService;
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("index.do")
	public ModelAndView getIndex(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/index"); 
		
		
		
		return modelAndView;
	}
}
