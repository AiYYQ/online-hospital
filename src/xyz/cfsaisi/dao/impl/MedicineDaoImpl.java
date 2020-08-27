package xyz.cfsaisi.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import xyz.cfsaisi.dao.MedicineDao;
import xyz.cfsaisi.entity.Doctor;
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
			sql.append(" and type="+Integer.parseInt(type));
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

	@Override
	public int insertMedicine(Medicine medicine) {
		String sql = "insert into medicine(mid,picture,inprice,salprice,name,type,descs,qualitydate,description,producefirm,readme,remark) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		int row = 0;
		try {
			row = qRunner.update(sql, medicine.getMid(),medicine.getPicture(),
					medicine.getInprice(),medicine.getSalprice(),medicine.getName(),
					medicine.getType(),medicine.getDescs(),medicine.getQualitydate(),
					medicine.getDescription(),medicine.getProduceFirm(),medicine.getReadme(),
					medicine.getRemark());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteMedicine(String[] split) {
		String sql = "delete from medicine where mid = ?";
		int row = 0;
		for (int i = 0; i < split.length; i++) {
			int j = 0;
			try {
				j = qRunner.update(sql, split[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			row += j;
		}
		return row;
	}

	@Override
	public Medicine lookMedicineById(String id) {
		String sql = "select * from medicine where mid = ?";
		Medicine medicine = null;
		try {
			medicine = qRunner.query(sql, new BeanHandler<Medicine>(Medicine.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicine;
	}

	@Override
	public int updateMedicine(Medicine medicine) {
		String sql = "update medicine set picture=?,inprice=?,salprice=?,name=?,type=?,descs=?,qualitydate=?,description=?,producefirm=?,readme=?,remark=? where mid=?";
		int row = 0;
		try {
			row = qRunner.update(sql, medicine.getPicture(),
					medicine.getInprice(),medicine.getSalprice(),medicine.getName(),
					medicine.getType(),medicine.getDescs(),medicine.getQualitydate(),
					medicine.getDescription(),medicine.getProduceFirm(),medicine.getReadme(),
					medicine.getRemark(),medicine.getMid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public List<Medicine> findMedicineById(String[] split) {
		List<Medicine> list = new ArrayList<Medicine>();
		String sql = "select picture from medicine where mid = ?";
		for (int i = 0; i < split.length; i++) {
			Medicine medicine = null;
			try {
				medicine = qRunner.query(sql, new BeanHandler<Medicine>(Medicine.class), split[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(medicine);
		}
		return list;
	}

}
