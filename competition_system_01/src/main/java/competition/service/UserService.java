package competition.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import competition.domain.Pagination;
import competition.domain.User;
import competition.domain.view.AuthView;
import competition.domain.view.MailView;
import competition.domain.view.UserView;

public interface UserService {
	public boolean addUser(UserView user);
	public boolean modifyUser(UserView user);
	public boolean removeUser(String userId, String userPW);
	public UserView getUser(String userId, String userPW);
	public List<UserView> findUsers(Pagination pagination);
	public boolean changePW(String userId, String preUserPW, String userPW);
	
	public int getAuthId(String authName);
	public String getAuthName(String userId);
	public List<AuthView> getAllAuths();
	public boolean getChkGroupPW(UserView user);
	public boolean forgetPW(String userId, String userPW);
}
