package test.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import test.service.MailService;

@Controller
public class MailController {
	//@Autowired
	MailService mailService;
	
	@RequestMapping("/mailtest.do")
	public void  test1(HttpServletRequest request){
		//Send a composed mail
		mailService.sendMail("cultisttp@gmail.com", "Test Subject", "Testing body");
		//Send a pre-configured mail
		mailService.sendPreConfiguredMail("Exception occurred everywhere.. where are you ????");
		
	}
}
