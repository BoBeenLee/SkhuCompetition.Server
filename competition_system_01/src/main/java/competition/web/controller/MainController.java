package competition.web.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
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
		modelAndView.addObject("mainType", "main");
		return modelAndView;
	}
	
	@RequestMapping(value = "/main/managecal.do", method = RequestMethod.GET)
	public ModelAndView viewManageCal(
			@ModelAttribute("calendarView1") CalendarView calendarView1) {
		ModelAndView modelAndView = new ModelAndView("/main/managecal");
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

	@RequestMapping(value = "/main/addCalendar.do", method = RequestMethod.POST)
	public ModelAndView addCalendar(@RequestParam("sd") String startDateView,
			@RequestParam("ed") String endDateView,
			@ModelAttribute("calendarView2") CalendarView calendarView2)
			throws ParseException {
		ModelAndView modelAndView = new ModelAndView("/main/managecal");
		boolean isCalendar = false;
		List<CalendarView> calendarList = null;
		
		int diff = DateUtils.getStringToTimestamp(endDateView).compareTo(DateUtils.getStringToTimestamp(startDateView));
		if(diff >= 0)
			calendarService.addCalendar(calendarView2);

		// 조회 
		CalendarView calendarView1 = new CalendarView();
		calendarView1.setStartDateView(startDateView);
		calendarView1.setEndDateView(endDateView);

		calendarList = calendarService.findCalendars(
				calendarView1.getStartDate(), calendarView1.getEndDate());

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
