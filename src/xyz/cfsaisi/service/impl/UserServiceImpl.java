package xyz.cfsaisi.service.impl;

import xyz.cfsaisi.dao.UserDao;
import xyz.cfsaisi.dao.impl.UserDaoImpl;
import xyz.cfsaisi.entity.User;
import xyz.cfsaisi.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	@Override 
	public User checkUsername(String username) {
		
		return userDao.checkUsername(username);
	}
	@Override
	public User checkEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.checkEmail(email);
	}
	@Override
	public boolean regist(User user) {
		// TODO Auto-generated method stub
		return userDao.regist(user);
	}
	@Override
	public User checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.checkLogin(username,password);
	}

}
