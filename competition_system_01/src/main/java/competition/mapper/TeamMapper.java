package competition.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import competition.domain.Rank;
import competition.domain.Team;
import competition.domain.code.TeamCode;
import competition.domain.view.TeamView;
import competition.domain.view.code.TeamCodeView;

public interface TeamMapper {
//	TeamCode
	public int addTeamCode(TeamCode teamCode);
	public int removeTeamCode(int teamCodeId);
	public int modifyTeamCode(TeamCode teamCode);
	public TeamCodeView getTeamCode(int teamCodeId);
	public List<TeamCodeView> findTeamCodes(@Param("boardCodeId") int boardCodeId, @Param("userId") String userId);
	public List<Rank> findRanks(int boardCodeId);
	
//	Team
	public int addTeam(Team team);
	public int removeTeam(int teamId);
	public TeamView getTeam(int teamId);
	public List<TeamView> findTeams(int teamCodeId);
	public int containsTeam(@Param("userId") String userId, @Param("boardCodeId") int boardCodeId);
}
