package bbs;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bbs.GuestbookMapper;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookMapper guestbookMapper;

	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView result = new ModelAndView("hello");
		result.addObject("message", "hello, world!");
		return result;
	}

	@RequestMapping("/list.do")
	public ModelAndView list() {
		ModelAndView result = new ModelAndView("list");
		result.addObject("list", guestbookMapper.selectAll());
		return result;
	}
}
