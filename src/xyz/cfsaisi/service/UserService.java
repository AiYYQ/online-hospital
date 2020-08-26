package xyz.cfsaisi.service;

import xyz.cfsaisi.entity.User;

public interface UserService {
	User checkUsername(String username);
	User checkEmail(String email);
	boolean regist(User user);
	User checkLogin(String username, String password);
}
