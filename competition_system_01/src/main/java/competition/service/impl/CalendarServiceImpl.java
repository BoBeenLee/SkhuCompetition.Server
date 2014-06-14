package competition.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import competition.domain.Calendar;
import competition.domain.view.CalendarView;
import competition.mapper.CalendarMapper;
import competition.service.CalendarService;

@Service("calendarService")
public class CalendarServiceImpl implements CalendarService {
	@Autowired(required=false)
	CalendarMapper calendarMapper;
		
	public boolean addCalendar(Calendar calendar) {
		boolean isCalendar = (1 == calendarMapper.addCalendar(calendar))? true : false;
		return isCalendar;
	}

	public boolean removeCalendar(int calendarId) {
		boolean isCalendar = (1 == calendarMapper.removeCalendar(calendarId))? true : false;
		return isCalendar;
	}

	public boolean modifyCalendar(Calendar calendar) {
		boolean isCalendar = (1 == calendarMapper.modifyCalendar(calendar))? true : false;
		return isCalendar;
	}

	public CalendarView getCalendar(int calendarId) {
		CalendarView calendar = calendarMapper.getCalendar(calendarId);
		return calendar;
	}

	public List<CalendarView> findCalendars(Timestamp startDate, Timestamp endDate) {
		List<CalendarView> calendarList = calendarMapper.findCalendars(startDate, endDate);
		return calendarList;
	}
	
}
