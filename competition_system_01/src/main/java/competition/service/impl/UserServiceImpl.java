package competition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import competition.domain.User;
import competition.domain.view.UserView;
import competition.mapper.UserMapper;
import competition.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	
	public boolean addUser(UserView user) {
		
		
		
		return false;
	}

	public boolean modifyUser() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeUser() {
		// TODO Auto-generated method stub
		return false;
	}

	public UserView getUser() {
		// TODO Auto-generated method stub
		return null;
	}
}
