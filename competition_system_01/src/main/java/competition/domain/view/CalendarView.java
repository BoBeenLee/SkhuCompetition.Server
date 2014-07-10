package competition.domain.view;

import java.text.ParseException;
import java.util.Date;

import util.DateUtils;
import competition.domain.Calendar;

public class CalendarView extends Calendar {
	
	public void setStartDateView(String startDate) throws ParseException {
		setStartDate(DateUtils.getStringToDate(startDate));
	}

	public void setEndDateView(String endDate) throws ParseException {
		setEndDate(DateUtils.getStringToDate(endDate));
	}

	public String getStartDateView() {
		return DateUtils.getDateToString(super.getStartDate());
	}

	public String getEndDateView() {
		return DateUtils.getDateToString(super.getEndDate());
	}
}
