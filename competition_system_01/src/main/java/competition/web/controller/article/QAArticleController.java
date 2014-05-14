package competition.web.controller.article;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QAArticleController {
	@RequestMapping("/qa/show.do")
	public ModelAndView showArticle(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/sub/qa"); 
		
		return modelAndView;
	}
}
