package competition.web.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import util.BeanUtils;
import competition.domain.Pagination;
import competition.domain.view.ArticleView;
import competition.domain.view.CalendarView;
import competition.service.ArticleService;
import competition.service.CalendarService;


@Controller
public class MainController {
	@Autowired
	CalendarService calendarService;
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("index.do")
	public ModelAndView getIndex(HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = new ModelAndView("/index"); 
		
//		 Calendar
		Calendar calendar = Calendar.getInstance();
		Timestamp startDate, endDate;
		calendar.set(calendar.get(Calendar.YEAR) - 2, calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
		startDate = new Timestamp(calendar.getTimeInMillis());
		calendar.set(calendar.get(Calendar.YEAR) + 4, calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
		endDate = new Timestamp(calendar.getTimeInMillis());

		List<CalendarView> calendarList = calendarService.findCalendars(startDate, endDate);
//		Notice
		Pagination pg1 = new Pagination();
		pg1.setBid(1); // Notice Number
		pg1.setSz(5);
		List<ArticleView> noticeList = articleService.findArticles(pg1);
		
//		Competition
		Pagination pg2 = new Pagination();
		pg2.setBid(2); // Competition Number
		pg2.setSz(5);
		List<ArticleView> competitionList = articleService.findArticles(pg2);
			
		modelAndView.addObject("calendarList", calendarList);
		modelAndView.addObject("noticeList", noticeList);
		modelAndView.addObject("competitionList", competitionList);
		return modelAndView;
	}
}
