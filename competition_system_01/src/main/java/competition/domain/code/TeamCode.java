package competition.domain.code;

import java.sql.Timestamp;

public class TeamCode {
	private int teamCodeId;
	private String leaderId;
	private String teamName;
	private int boardCodeId;
	private Timestamp teamDate;
	private String teamType;
	private String teamContent;
	private int isPermission;
	
	public int getTeamCodeId() {
		return teamCodeId;
	}
	public void setTeamCodeId(int teamCodeId) {
		this.teamCodeId = teamCodeId;
	}
	public String getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getBoardCodeId() {
		return boardCodeId;
	}
	public void setBoardCodeId(int boardCodeId) {
		this.boardCodeId = boardCodeId;
	}
	public Timestamp getTeamDate() {
		return teamDate;
	}
	public void setTeamDate(Timestamp teamDate) {
		this.teamDate = teamDate;
	}
	public String getTeamType() {
		return teamType;
	}
	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}
	public String getTeamContent() {
		return teamContent;
	}
	public void setTeamContent(String teamContent) {
		this.teamContent = teamContent;
	}
	public int getIsPermission() {
		return isPermission;
	}
	public void setIsPermission(int isPermission) {
		this.isPermission = isPermission;
	}
	
}
