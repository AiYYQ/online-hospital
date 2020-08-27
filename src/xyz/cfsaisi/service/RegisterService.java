package xyz.cfsaisi.service;

import java.util.List;

import xyz.cfsaisi.entity.Register;
import xyz.cfsaisi.utils.PageUtils;

public interface RegisterService {

	int findAllRegisterCount(String rid, String name, String department);

	List<Register> findRegister(String rid, String name, String department, PageUtils<Register> pUtils);

	Register findRegisterById(String rid);

}
