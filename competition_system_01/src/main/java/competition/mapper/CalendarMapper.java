package competition.mapper;

import java.util.List;

import competition.domain.Article;
import competition.domain.Calendar;
import competition.domain.Pagination;
import competition.domain.code.BoardCode;
import competition.domain.view.ArticleView;
import competition.domain.view.CalendarView;
import competition.domain.view.QAView;

public interface CalendarMapper {
	// Calendar
	public void addCalendar(Calendar calendar);
	public void removeCalendar(int id);	
	public void modifyCalendar(Calendar calendar);
	public CalendarView getCalendar(int id);
	public List<CalendarView> findCalendar();
}