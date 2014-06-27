package competition.domain;

import java.sql.Timestamp;
import java.util.Date;

public class Calendar {
	private int calendarId;
	private Timestamp startDate;
	private Timestamp endDate;
	private String content;

	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Date date) {
		this.startDate = new Timestamp(date.getTime());
	}
	
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date date) {
		this.endDate = new Timestamp(date.getTime());
	}
	
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
