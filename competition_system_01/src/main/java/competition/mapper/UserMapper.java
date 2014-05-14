package competition.mapper;

import java.util.List;

import competition.domain.Pagination;
import competition.domain.User;
import competition.domain.view.UserView;

public interface UserMapper {
	public void addUser(User user);
	public void removeUser(int id);
	public void modifyUser(User user);
	public List<UserView> findUser(Pagination pagination);
	
}
