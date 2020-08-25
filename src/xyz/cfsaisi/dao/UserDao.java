package xyz.cfsaisi.dao;

import xyz.cfsaisi.entity.User;

public interface UserDao {

	User checkUsername(String username);

	User checkEmail(String email);
}
