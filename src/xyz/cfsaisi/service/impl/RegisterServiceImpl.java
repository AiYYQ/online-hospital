package xyz.cfsaisi.service.impl;

import java.util.List;

import xyz.cfsaisi.dao.RegisterDao;
import xyz.cfsaisi.dao.impl.RegisterDaoImpl;
import xyz.cfsaisi.entity.Register;
import xyz.cfsaisi.service.RegisterService;
import xyz.cfsaisi.utils.PageUtils;

public class RegisterServiceImpl implements RegisterService {
	
	private RegisterDao rDao = new RegisterDaoImpl();

	@Override
	public int findAllRegisterCount(String rid, String name, String department) {
		return rDao.findAllRegisterCount(rid,name,department);
	}

	@Override
	public List<Register> findRegister(String rid ,String name, String department, PageUtils<Register> pUtils) {
		return rDao.findRegister(rid,name,department,pUtils);
	}

	@Override
	public Register findRegisterById(String rid) {
		return rDao.findRegisterById(rid);
	}

}
