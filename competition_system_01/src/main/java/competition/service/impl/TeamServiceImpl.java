package competition.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import competition.domain.Rank;
import competition.domain.Team;
import competition.domain.code.TeamCode;
import competition.domain.view.TeamView;
import competition.domain.view.code.TeamCodeView;
import competition.mapper.TeamMapper;
import competition.service.TeamService;

@Service("teamService")
public class TeamServiceImpl implements TeamService {
	@Autowired(required=false)
	TeamMapper teamMapper;
	
	public boolean addTeamCode(TeamCode teamCode) {
		boolean isTeamCode = (1 == teamMapper.addTeamCode(teamCode))? true : false;
		return isTeamCode;
	}

	public boolean modifyTeamCode(TeamCode teamCode) {
		boolean isTeamCode = (1 == teamMapper.modifyTeamCode(teamCode))? true : false;
		return isTeamCode;
	}

	public boolean removeTeamCode(int teamCodeId) {
		boolean isTeamCode = (1 == teamMapper.removeTeamCode(teamCodeId))? true : false;
		return isTeamCode;
	}
	
	public TeamCodeView getTeamCode(int teamCodeId) {
		TeamCodeView teamCode = teamMapper.getTeamCode(teamCodeId);
		return teamCode;
	}

	public List<TeamCodeView> findTeamCodes(int boardCodeId, String userId) {
		List<TeamCodeView> teamCodeList = teamMapper.findTeamCodes(boardCodeId, userId);
		return teamCodeList;
	}

	public List<Rank> findRanks(int boardCodeId) {
		List<Rank> rankList = teamMapper.findRanks(boardCodeId);
		return rankList;
	}

	public boolean addTeam(Team team) {
		boolean isTeam = (1 == teamMapper.addTeam(team))? true : false;
		return isTeam;
	}

	public boolean removeTeam(int teamId) {
		boolean isTeam = (1 == teamMapper.removeTeam(teamId))? true : false;
		return isTeam;
	}
	
	public TeamView getTeam(int teamId) {
		TeamView team = teamMapper.getTeam(teamId);
		return team;
	}

	public List<TeamView> findTeams(int teamCodeId) {
		List<TeamView> teamList = teamMapper.findTeams(teamCodeId);
		return teamList;
	}

	public boolean containsTeam(String userId, int boardCodeId) {
		boolean isTeam = (teamMapper.containsTeam(userId, boardCodeId) == 1)? true : false;
		return isTeam;
	}
}
