package competition.web.controller.article;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import competition.service.ArticleService;
import competition.service.impl.ArticleServiceImpl;


@Controller
public class ArticleController {
	/* @Autowired
	ArticleService articleService; 
	*/
	@RequestMapping(value="/article/show.do", method=RequestMethod.GET)
	public ModelAndView showArticle(@PathVariable int id, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/article/show"); 
		
		return modelAndView;
	}
	
	@RequestMapping("/article/modify.do")
	public ModelAndView modifyArticle(@PathVariable int id, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/article/modify"); 
		
		return modelAndView;
	}
	
	@RequestMapping("/article/write.do")
	public ModelAndView writeArticle(@PathVariable int id, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/article/write"); 
		
		return modelAndView;
	}
	
	@RequestMapping("/article/remove/{id}.do")
	public ModelAndView removeArticle(@PathVariable int id, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/article/remove"); 
		
		return modelAndView;
	}
}
