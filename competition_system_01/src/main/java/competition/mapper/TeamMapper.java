package competition.mapper;

import java.util.List;

import competition.domain.Pagination;
import competition.domain.Team;
import competition.domain.User;
import competition.domain.view.TeamView;
import competition.domain.view.UserView;

public interface TeamMapper {
	public void addTeam(Team team);
	public void removeTeam(int id);
	public void modifyTeam(Team team);
	public List<TeamView> findTeam(Pagination pagination);
}
