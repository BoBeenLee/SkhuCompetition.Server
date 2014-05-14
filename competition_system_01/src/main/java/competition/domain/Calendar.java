package competition.domain;

import java.sql.Timestamp;

public class Calendar {
	private int calendarId;
	private int boardCodeId;
	private Timestamp startDate;
	private Timestamp endDate;
	private String content;
	private int calendarHidden;

	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	public int getBoardCodeId() {
		return boardCodeId;
	}

	public void setBoardCodeId(int boardCodeId) {
		this.boardCodeId = boardCodeId;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
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

	public int getCalendarHidden() {
		return calendarHidden;
	}

	public void setCalendarHidden(int calendarHidden) {
		this.calendarHidden = calendarHidden;
	}
}
