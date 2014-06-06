package competition.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import competition.domain.Page;
import competition.domain.view.UserView;
import competition.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
//	<!-- User -->
	@RequestMapping("/user/login.do")
	public ModelAndView getLogin(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/user/login"); 
		
		modelAndView.addObject("subTitle", "로그인");
		modelAndView.addObject("userType", "login");
		return modelAndView;
	}
	
	@RequestMapping(value="/user/forget.do", method=RequestMethod.GET)
	public ModelAndView viewForget(){
		ModelAndView modelAndView = new ModelAndView("/user/forget"); 
		
		modelAndView.addObject("subTitle", "비밀번호 찾기");
		modelAndView.addObject("userType", "forget");
		return modelAndView;
	}
	
	@RequestMapping(value="/user/forget.do", method=RequestMethod.POST)
	public String forget(){
		String url = "";
		
		
		
		return url;
	}
	
	@RequestMapping(value="/user/register.do", method=RequestMethod.GET)
	public ModelAndView viewRegister(){
		ModelAndView modelAndView = new ModelAndView("/user/register"); 	
		
		modelAndView.addObject("subTitle", "회원가입");
		modelAndView.addObject("userType", "register");
		return modelAndView;
	}
	
	@RequestMapping(value="/user/register.do", method=RequestMethod.POST)
	public String register(@ModelAttribute("userView") UserView userView){
		String url = "";
		boolean isUser = false;
		
		boolean isGroupPwChk = userService.getChkGroupPW(userView);
		
		if(isGroupPwChk)
			System.out.println((isUser = userService.addUser(userView)));	

	    if(isUser)
	    	url = "redirect:" + "/index.do?message=register";
	    else
	    	url = "redirect:" + "/index.do?message=fail";			
		return url;
	}	
}
