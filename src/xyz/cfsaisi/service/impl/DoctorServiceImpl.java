package xyz.cfsaisi.service.impl;

import java.util.List;

import xyz.cfsaisi.dao.DoctorDao;
import xyz.cfsaisi.dao.impl.DoctorDaoImpl;
import xyz.cfsaisi.entity.Doctor;
import xyz.cfsaisi.service.DoctorService;
import xyz.cfsaisi.utils.PageUtils;

public class DoctorServiceImpl implements DoctorService {

	private DoctorDao doctorDao = new DoctorDaoImpl();
	@Override
	public List<Doctor> findDoctor(String name,String department,PageUtils<Doctor> pUtils) {
		// TODO Auto-generated method stub
		return doctorDao.findDoctor(name,department,pUtils);
	}
	@Override
	public int findAllDoctorCount(String name,String department) {
		// TODO Auto-generated method stub
		return doctorDao.selectAllDoctorCount(name,department);
	}
	@Override
	public Doctor lookDectorById(String id) {
		return doctorDao.selectDoctorById(id);
	}
	@Override
	public int updateDocterById(Doctor doctor) {
		return doctorDao.updateDoctorById(doctor);
	}
	@Override
	public int addDoctor(Doctor doctor) {
		return doctorDao.insertDoctor(doctor);
	}
	@Override
	public int deleteDoctor(String[] ids) {
		return doctorDao.deleteDoctor(ids);
	}

}
