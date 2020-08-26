package xyz.cfsaisi.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.xpath.internal.operations.And;

import xyz.cfsaisi.dao.DoctorDao;
import xyz.cfsaisi.entity.Doctor;
import xyz.cfsaisi.utils.JDBCUtils;
import xyz.cfsaisi.utils.PageUtils;

public class DoctorDaoImpl implements DoctorDao {
	private QueryRunner qRunner = JDBCUtils.getQueryRunner();

	@Override
	public List<Doctor> findDoctor(String name,String department,PageUtils<Doctor> pUtils) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("select * from doctor where 1=1");
		if (name != null && name != "") {
			sql.append(" and name like '%" + name + "%'");
		}
		if (department != null && department != "") {
			sql.append(" and department="+department);
		}
		sql.append(" limit "+pUtils.getCurrentStart()+","+pUtils.getPageSize());
		List<Doctor> list = null;
		try {
			list = qRunner.query(sql.toString(), new BeanListHandler<Doctor>(Doctor.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int selectAllDoctorCount(String name,String department) {
		StringBuilder sql = new StringBuilder("select count(*) from doctor where 1=1");
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
	public Doctor selectDoctorById(String id) {
		String sql = "select * from doctor where did = ?";
		Doctor doctor = null;
		try {
			doctor = qRunner.query(sql, new BeanHandler<Doctor>(Doctor.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doctor;
	}

	@Override
	public int updateDoctorById(Doctor doctor) {
		String sql = "update doctor set name=?,cardno=?,phone=?,sex=?,age=?,birthday=?,email=?,department=?,education=?,remark=? where did=?";
		int row = 0;
		try {
			row = qRunner.update(sql, doctor.getName(),doctor.getCardno(),doctor.getPhone(),doctor.getSex(),doctor.getAge(),doctor.getBirthday(),doctor.getEmail(),doctor.getDepartment(),doctor.getEducation(),doctor.getRemark(),doctor.getDid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int insertDoctor(Doctor doctor) {
		String sql = "insert into doctor(name,cardno,phone,sex,age,birthday,email,department,education,remark) values(?,?,?,?,?,?,?,?,?,?)";
		int row = 0;
		try {
			row = qRunner.update(sql, doctor.getName(),doctor.getCardno(),doctor.getPhone(),doctor.getSex(),doctor.getAge(),doctor.getBirthday(),doctor.getEmail(),doctor.getDepartment(),doctor.getEducation(),doctor.getRemark());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteDoctor(String[] ids) {
		String sql = "delete from doctor where did = ?";
		int row = 0;
		try {
			for (int i = 0; i < ids.length; i++) {
				int j = qRunner.update(sql, ids[i]);
				row += j;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

}
