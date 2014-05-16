package competition.service;

import competition.domain.User;
import competition.domain.view.UserView;

public interface UserService {
	public boolean addUser(UserView user);
	public boolean modifyUser();
	public boolean removeUser();
	public UserView getUser();
}
