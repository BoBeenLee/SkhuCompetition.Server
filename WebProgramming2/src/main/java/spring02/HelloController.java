package spring02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@Autowired
	@Qualifier("student1")
	private Student student;
	
	@Autowired
	@Qualifier("student1")
	private Student student1;
	
	@Autowired
	@Qualifier("student2")
	private Student student2;
	
	@Autowired
	@Qualifier("student3")
	private Student student3;
	
	@Autowired
	@Qualifier("student4")
	private Student student4;
	
	@Autowired
	@Qualifier("student5")
	private Student student5;
	
	@RequestMapping("/test1.do")
	public ModelAndView test1(){
		ModelAndView result = new ModelAndView("test1");
		
		result.addObject("student", student);
		result.addObject("student1", student1);
		result.addObject("student2", student2);
		result.addObject("student3", student3);
		result.addObject("student4", student4);
		result.addObject("student5", student5);
		return result;
	}
}
