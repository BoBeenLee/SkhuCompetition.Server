package competition.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import competition.domain.Pagination;
import competition.domain.view.AuthView;
import competition.domain.view.MailView;
import competition.domain.view.UserView;

public interface UserMapper {
//	User
	public int addUser(UserView user);
	public int removeUser(@Param("userId") String userId, @Param("userPW") String userPW);
	public int modifyUser(UserView user);
	public UserView getUser(@Param("userId") String userId, @Param("userPW") String userPW);
	public List<UserView> findUsers(Pagination pagination);
	public int changePW(@Param("userId") String userId, @Param("preUserPW") String preUserPW, @Param("userPW") String userPW);
	
	public int getAuthId(String authName);
	public String getAuthName(String userId);
	public List<AuthView> getAllAuths();
	public int getChkGroupPW(UserView user);
	public int forgetPW(@Param("userId") String userId, @Param("userPW") String userPW);
//	Mail
	public MailView getEmail(@Param("userId") String userId, @Param("question") String question, @Param("answer") String answer);
}
