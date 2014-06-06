package competition.service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import competition.domain.Calendar;
import competition.domain.view.CalendarView;

public interface CalendarService {
	// Calendar
	public boolean addCalendar(Calendar calendar);
	public boolean removeCalendar(int calendarId);	
	public boolean modifyCalendar(Calendar calendar);
	
	public CalendarView getCalendar(int calendarId);
	public List<CalendarView> findCalendars(Timestamp startDate, Timestamp endDate);
}
