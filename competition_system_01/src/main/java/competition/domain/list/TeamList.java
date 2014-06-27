package competition.domain.list;

import java.util.List;

import competition.domain.view.TeamView;

public class TeamList {
	private List<TeamView> teams;
	private int boardCodeId;
	private int teamCodeId;
	private int isPermission;
	private String leaderId;
	
	public TeamList() {
		super();
	}
	
	public List<TeamView> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamView> teams) {
		this.teams = teams;
	}
	
	public int getBoardCodeId() {
		return boardCodeId;
	}

	public void setBoardCodeId(int boardCodeId) {
		this.boardCodeId = boardCodeId;
	}

	public int getTeamCodeId() {
		return teamCodeId;
	}

	public void setTeamCodeId(int teamCodeId) {
		this.teamCodeId = teamCodeId;
	}

	public int getIsPermission() {
		return isPermission;
	}

	public void setIsPermission(int isPermission) {
		this.isPermission = isPermission;
	}

	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
}
