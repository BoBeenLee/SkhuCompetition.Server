package competition.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import competition.service.ArticleService;

@Controller
public class NoticeController {
	
	@Autowired
	ArticleService articleService;
	
	
	@RequestMapping("notice.do")
	public ModelAndView getCompetitionBoard(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/sub1/board"); 
		
		modelAndView.addObject("noticeList", articleService.findArticle());
		
		
		return modelAndView;
	}
}
