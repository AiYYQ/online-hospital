package xyz.cfsaisi.dao;

import xyz.cfsaisi.entity.User;

public interface UserDao {

	User checkUsername(String username);

	User checkEmail(String email);

	boolean regist(User user);

	User checkLogin(String username, String password);
}
