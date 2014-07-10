package competition.domain.code;

import java.sql.Timestamp;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TeamCode {
	public static final int IS_NOT_PERMISSION = 0;
	public static final int IS_PERMISSION = 1;
	
	private int teamCodeId;
	private String leaderId;
	@NotEmpty @Length(min = 3, max = 20, message = "TeamName 3 ~ 20")
	private String teamName;
	@Range(min = 1, message = "해당 보드를 찾을 수 없습니다.")
	private int boardCodeId;
	private Timestamp teamDate;
	private String teamType;
	@NotEmpty @Length(min = 3, max = 20, message = "Team Content 3 ~ 20")
	private String teamContent;
	private int isPermission;
	
	public TeamCode() {
		super();
	}
	
	public TeamCode(int teamCodeId, String leaderId, String teamName,
			int boardCodeId, Timestamp teamDate, String teamType,
			String teamContent, int isPermission) {
		super();
		this.teamCodeId = teamCodeId;
		this.leaderId = leaderId;
		this.teamName = teamName;
		this.boardCodeId = boardCodeId;
		this.teamDate = teamDate;
		this.teamType = teamType;
		this.teamContent = teamContent;
		this.isPermission = isPermission;
	}
	
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
