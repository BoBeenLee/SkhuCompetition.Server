package competition.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import competition.domain.Calendar;
import competition.domain.view.CalendarView;

public interface CalendarMapper {
	// Calendar
	public int addCalendar(Calendar calendar);
	public int removeCalendar(int calendarId);	
	public int modifyCalendar(Calendar calendar);
	
	public CalendarView getCalendar(int calendarId);
	public List<CalendarView> findCalendars(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);
}
