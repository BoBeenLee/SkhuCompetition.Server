package competition.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import competition.domain.User;
import competition.domain.view.UserView;
import competition.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("login.do")
	public ModelAndView getLogin(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/sub/qa"); 
		
		return modelAndView;
		
	}
	@RequestMapping("logout.do")
	public ModelAndView getLogout(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/sub/qa"); 
		
		return modelAndView;
		
	}
	
	@RequestMapping("register.do")
	public ModelAndView getRegister(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/sub1/user/register"); 
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="sendRegister.do", method=RequestMethod.POST)
	public ModelAndView sendRegister(UserView userView){
		ModelAndView modelAndView = new ModelAndView("/index"); 
		
	//	boolean chk = userService.addUser(user);
		
		System.out.println(true);
		
		return modelAndView;
		
	}
	
	
	
}
