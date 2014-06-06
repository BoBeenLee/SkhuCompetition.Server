package competition.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import competition.domain.Pagination;
import competition.domain.view.UserView;
import competition.mapper.UserMapper;
import competition.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	
	public boolean addUser(UserView user) {
		boolean isUser = (1 == userMapper.addUser(user))? true : false;		

		return isUser;
	}

	public boolean modifyUser(UserView user) {
		boolean isUser = (1 == userMapper.modifyUser(user))? true : false;		

		return isUser;
	}

	public boolean removeUser(String userId, String userPW) {
		boolean isUser = (1 == userMapper.removeUser(userId, userPW))? true : false;		
		return isUser;
	}

	public UserView getUser(String userId, String userPW) {
		UserView user = userMapper.getUser(userId, userPW);
		
		return user;
	}

	public List<UserView> findUsers(Pagination pagination) {
		List<UserView> userList = userMapper.findUsers(pagination);
		
		return userList;
	}

	public boolean changePW(String userId, String preUserPW, String userPW) {
		boolean isUser = (1 == userMapper.changePW(userId, preUserPW, userPW))? true : false;		
		
		return isUser;
	}

	public int getAuthId(String authName) {
		int authId = userMapper.getAuthId(authName);
		
		return authId;
	}

	public String getAuthName(String userId){
		return userMapper.getAuthName(userId);
	}
	
	public boolean getChkGroupPW(UserView user) {
		boolean isChk = 	(1 == userMapper.getChkGroupPW(user))? true : false;		
		
		return isChk;
	}
}
