package competition.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import competition.domain.Rank;
import competition.domain.Team;
import competition.domain.code.TeamCode;
import competition.domain.view.TeamView;
import competition.domain.view.code.TeamCodeView;

public interface TeamService {
//	TeamCode
	public boolean addTeamCode(TeamCode teamCode);
	public boolean removeTeamCode(int teamCodeId);
	public boolean modifyTeamCode(TeamCode teamCode);
	public TeamCodeView getTeamCode(int teamCodeId);
	public List<TeamCodeView> findTeamCodes(int boardCodeId, String userId);
	public List<Rank> findRanks(int boardCodeId);
	
//	Team
	public boolean addTeam(Team team);
	public boolean removeTeam(int teamId);
	public TeamView getTeam(int teamId);
	public List<TeamView> findTeams(int teamCodeId);
	public boolean containsTeam(String userId, int boardCodeId);
}
