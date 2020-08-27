package xyz.cfsaisi.dao;

import java.util.List;

import xyz.cfsaisi.entity.Register;
import xyz.cfsaisi.utils.PageUtils;

public interface RegisterDao {

	int findAllRegisterCount(String rid, String name, String department);

	List<Register> findRegister(String rid,String name, String department, PageUtils<Register> pUtils);

	Register findRegisterById(String rid);

}
