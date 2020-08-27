package xyz.cfsaisi.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import xyz.cfsaisi.dao.RegisterDao;
import xyz.cfsaisi.entity.Doctor;
import xyz.cfsaisi.entity.Register;
import xyz.cfsaisi.utils.JDBCUtils;
import xyz.cfsaisi.utils.PageUtils;

public class RegisterDaoImpl implements RegisterDao {

	private QueryRunner qRunner = JDBCUtils.getQueryRunner();

	@Override
	public int findAllRegisterCount(String rid, String name, String department) {
		StringBuilder sql = new StringBuilder("select count(*) from register where 1=1");
		if (rid != null && rid != "") {
			sql.append(" and rid = "+rid);
		}
		if (name != null && name != "") {
			sql.append(" and name like '%" + name + "%'");
		}
		if (department != null && department != "") {
			sql.append(" and department="+department);
		}
		Long row = null;
		try {
			row = qRunner.query(sql.toString(), new ScalarHandler<Long>());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row.intValue();
	}

	@Override
	public List<Register> findRegister(String rid,String name, String department, PageUtils<Register> pUtils) {
		//StringBuilder sql = new StringBuilder("select r.*,d.name from register r,doctor d where 1=1 and r.did=d.did");
		StringBuilder sql = new StringBuilder("select * from register r where 1=1");
		if (rid != null && rid != "" ) {
			sql.append(" and r.rid = "+rid);
		}
		if (name != null && name != "") {
			sql.append(" and r.name like '%" + name + "%'");
		}
		if (department != null && department != "") {
			sql.append(" and r.department="+department);
		}
		sql.append(" limit "+pUtils.getCurrentStart()+","+pUtils.getPageSize());
		
		List<Register> list = null;
		try {
			list = qRunner.query(sql.toString(), new BeanListHandler<Register>(Register.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			String did = list.get(i).getDid();
			String sql2 = "select * from doctor where did = ?";
			try {
				Doctor doctor = qRunner.query(sql2, new BeanHandler<Doctor>(Doctor.class),did);
				list.get(i).setDoctor(doctor);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Register findRegisterById(String rid) {
		String sql = "select * from register where rid = ?";
		Register register = null;
		try {
			register = qRunner.query(sql, new BeanHandler<Register>(Register.class),rid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return register;
	}
	
	
}
