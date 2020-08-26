package xyz.cfsaisi.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import xyz.cfsaisi.dao.UserDao;
import xyz.cfsaisi.entity.User;
import xyz.cfsaisi.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {
	
	private QueryRunner qRunner = JDBCUtils.getQueryRunner();

	@Override
	public User checkUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "select username from users where username = ?";
		User user = null;
		try {
			user = qRunner.query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User checkEmail(String email) {
		String sql = "select email from users where email = ?";
		User user = null;
		try {
			user = qRunner.query(sql, new BeanHandler<User>(User.class),email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean regist(User user) {
		String sql = "insert into users(name,password,username,email,modifytime) values(?,?,?,?,?)";
		int rows = 0;
		try {
			rows = qRunner.update(sql, user.getName(),user.getPassword(),user.getUsername(),user.getEmail(),user.getModifytime());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public User checkLogin(String username, String password) {
		String sql = "select * from users where username=? and password = ?";
		User user = null;
		try {
			user = qRunner.query(sql, new BeanHandler<User>(User.class),username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return user;
	}
}
