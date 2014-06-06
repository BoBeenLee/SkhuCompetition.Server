package competition.domain.view;

import java.text.ParseException;

import util.DateUtils;

import competition.domain.Calendar;

public class CalendarView extends Calendar {
	public void setStartDateView(String startDate) throws ParseException {
		setStartDate(DateUtils.getStringToTimestamp(startDate));
	}

	public void setEndDateView(String endDate) throws ParseException {
		setEndDate(DateUtils.getStringToTimestamp(endDate));
	}

	public String getStartDateView() {
		return DateUtils.getTimestampToString(super.getStartDate());
	}

	public String getEndDateView() {
		return DateUtils.getTimestampToString(super.getEndDate());
	}
}
