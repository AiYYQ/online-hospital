package xyz.cfsaisi.service;

import xyz.cfsaisi.entity.User;

public interface UserService {
	User checkUsername(String username);
	User checkEmail(String email);
}
