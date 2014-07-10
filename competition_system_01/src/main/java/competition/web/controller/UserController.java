package competition.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import competition.domain.Page;
import competition.domain.view.MailView;
import competition.domain.view.UserView;
import competition.service.MailService;
import competition.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	MailService mailService;
	
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
	public String forget(@RequestParam(value="userEmail", required=false) String userEmail, @RequestParam(value="userId", required=false) String userId, @RequestParam(value="question", required=false) String question, @RequestParam(value="answer", required=false) String answer){
		String toMail = null;
		
		if(userId != null && question != null && answer != null){
			MailView mailView = mailService.getEmail(userId, question, answer);
			toMail = mailView.getToMail();
		}
		if(userId != null && userEmail != null){
			MailView mailView = mailService.getEmail(userId, null, null);
			toMail = mailView.getToMail().equals(userEmail)? userEmail : null;
		}
		if(userId != null && toMail != null){
//			System.out.println(userId + " - " + toMail);
			userService.forgetPW(userId, "test");
			mailService.sendMail(toMail, "비밀번호 변경 완료", "비밀번호 : test");
		}
		return  "redirect:" + "/main/main.do?message=forget";
	}
	
	@RequestMapping(value="/user/register.do", method=RequestMethod.GET)
	public ModelAndView viewRegister(){
		ModelAndView modelAndView = new ModelAndView("/user/register"); 	
		
		modelAndView.addObject("subTitle", "회원가입");
		modelAndView.addObject("userType", "register");
		return modelAndView;
	}
	
	@RequestMapping(value="/user/register.do", method=RequestMethod.POST)
	public String register(@ModelAttribute("userView") @Valid UserView userView){
		String url = "";
		boolean isUser = false;
		
//		System.out.println(userView.getAuthName());
//		boolean isGroupPwChk = userService.getChkGroupPW(userView);
		
//		if(isGroupPwChk)
		System.out.println((isUser = userService.addUser(userView)));	

	    if(isUser)
	    	url = "redirect:" + "/main/main.do?message=register";
	    else
	    	url = "redirect:" + "/user/register.do";			
		return url;
	}	
}
