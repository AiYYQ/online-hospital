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
			user = qRunner.query(sql, new BeanHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
