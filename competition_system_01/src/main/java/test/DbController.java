package test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DbController {
	@Autowired
	TestMapper tm;
	
	@RequestMapping("/dbtest.do")
	public ModelAndView page1(HttpServletRequest request) {
		ModelAndView result = new ModelAndView("layout");
		
		
		
		return result;
	}
}
