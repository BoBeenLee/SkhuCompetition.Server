package competition.web.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import util.BeanUtils;
import util.DateUtils;
import competition.domain.Pagination;
import competition.domain.code.BoardCode;
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
	
	@RequestMapping("/main/main.do")
	public ModelAndView getIndex(HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = new ModelAndView("/main/main"); 
		
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
		pg1.setBid(BoardCode.BOARDCODE_NOTICE); // Notice Number
		pg1.setSz(3);
		List<ArticleView> noticeList = articleService.findArticles(pg1);
		
//		Competition
		Pagination pg2 = new Pagination();
		pg2.setBid(BoardCode.BOARDCODE_COMPETITION); // Competition Number
		pg2.setSz(5);
		List<ArticleView> competitionList = articleService.findArticles(pg2);
			
//		QnA
		Pagination pg3 = new Pagination();
		pg3.setBid(BoardCode.BOARDCODE_QA); // QnA Number
		pg3.setSz(3);
		List<ArticleView> qnaList = articleService.findArticles(pg3);
		
		modelAndView.addObject("calendarList", calendarList);
		modelAndView.addObject("noticeList", noticeList);
		modelAndView.addObject("competitionList", competitionList); 
		modelAndView.addObject("qnaList", qnaList); 
		modelAndView.addObject("mainType", "main");
		return modelAndView;
	}
	
	@RequestMapping(value = "/main/managecal.do", method = RequestMethod.GET)
	public ModelAndView viewManageCal(
			@ModelAttribute("calendarView1") CalendarView calendarView1) {
		ModelAndView modelAndView = new ModelAndView("/main/managecal");
		List<CalendarView> calendarList = null;
		
		if(calendarView1.getStartDate() == null || calendarView1.getEndDate() == null){
			Calendar c1 = Calendar.getInstance();
			calendarView1.setStartDate(c1.getTime());
			c1.set(Calendar.DATE, c1.get(Calendar.DATE) + 30);
			calendarView1.setEndDate(c1.getTime());
		}
		if (calendarView1.getEndDate().compareTo(calendarView1.getStartDate()) >= 0 && calendarView1 != null) {
			calendarList = calendarService.findCalendars(
					calendarView1.getStartDate(), calendarView1.getEndDate());
		} 
		
		modelAndView.addObject("calendarList", calendarList);
		modelAndView.addObject("calendarView2", new CalendarView());
		modelAndView.addObject("subTitle", "달력관리");
		modelAndView.addObject("mainType", "managecal");
		return modelAndView;
	}

	@RequestMapping(value = "/main/addCalendar.do", method = RequestMethod.POST)
	public ModelAndView addCalendar(@RequestParam("sd") String startDateView,
			@RequestParam("ed") String endDateView,
			@ModelAttribute("calendarView2") CalendarView calendarView2)
					throws ParseException {
		ModelAndView modelAndView = new ModelAndView("/main/managecal");
		boolean isCalendar = false;
		List<CalendarView> calendarList = null;
		CalendarView calendarView1 = new CalendarView();
		
		if(calendarView2.getEndDate().compareTo(calendarView2.getStartDate()) >= 0)	
			calendarService.addCalendar(calendarView2);

		// 조회 
		if(startDateView != null && startDateView != "" && endDateView != null && endDateView != ""){
			calendarView1.setStartDateView(startDateView);
			calendarView1.setEndDateView(endDateView);

			calendarList = calendarService.findCalendars(calendarView1.getStartDate(), calendarView1.getEndDate());
		}
		calendarView2 = new CalendarView();
		modelAndView.addObject("calendarList", calendarList);
		modelAndView.addObject("calendarView1", calendarView1);
		modelAndView.addObject("subTitle", "달력관리");
		modelAndView.addObject("mainType", "managecal");
		return modelAndView;
	}

	@RequestMapping(value = "/main/removeCalendar.do", method = RequestMethod.GET)
	public ModelAndView removeCalendar(@RequestParam("cId") int calendarId,
			@ModelAttribute("calendarView1") CalendarView calendarView1) {
		ModelAndView modelAndView = new ModelAndView("/main/managecal");
		boolean isCalendar = calendarService.removeCalendar(calendarId);
		List<CalendarView> calendarList = null;

		if (calendarView1 != null) {
			calendarList = calendarService.findCalendars(
					calendarView1.getStartDate(), calendarView1.getEndDate());
		} else
			calendarView1 = new CalendarView();

		modelAndView.addObject("calendarList", calendarList);
		modelAndView.addObject("calendarView2", new CalendarView());
		modelAndView.addObject("subTitle", "달력관리");
		modelAndView.addObject("mainType", "managecal");
		return modelAndView;
	}
}
