package spring04_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/page1.do")
	public ModelAndView page1() {
		ModelAndView result = new ModelAndView("page1");
		result.addObject("message", "페이지1의 출력");
		return result;
	}

	@RequestMapping("/page2.do")
	public ModelAndView page2() {
		ModelAndView result = new ModelAndView("page2");
		result.addObject("message", "페이지2의 출력");
		return result;
	}

	@RequestMapping("/page3.do")
	public ModelAndView page3() {
		ModelAndView result = new ModelAndView("page3");
		result.addObject("message", "페이지3의 출력");
		return result;
	}
}
