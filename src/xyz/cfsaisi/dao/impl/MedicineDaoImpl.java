package xyz.cfsaisi.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import xyz.cfsaisi.dao.MedicineDao;
import xyz.cfsaisi.entity.Medicine;
import xyz.cfsaisi.utils.JDBCUtils;
import xyz.cfsaisi.utils.PageUtils;

public class MedicineDaoImpl implements MedicineDao {

	private QueryRunner qRunner = JDBCUtils.getQueryRunner();
	
	@Override
	public int findMedicineCount(String name, String type) {
		StringBuilder sql = new StringBuilder("select count(*) from medicine where 1=1");
		if (name != null && name != "") {
			sql.append(" and name like '%" + name + "%'");
		}
		if (type != null && type != "") {
			sql.append(" and type="+type);
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
	public List<Medicine> findMedicine(String name, String type, PageUtils<Medicine> pUtils) {
		StringBuilder sql = new StringBuilder("select * from medicine where 1=1");
		if (name != null && name != "") {
			sql.append(" and name like '%" + name + "%'");
		}
		if (type != null && type != "") {
			sql.append(" and type="+type);
		}
		sql.append(" limit "+pUtils.getCurrentStart()+","+pUtils.getPageSize());
		List<Medicine> list = null;
		try {
			list = qRunner.query(sql.toString(), new BeanListHandler<Medicine>(Medicine.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
