package xyz.cfsaisi.dao;

import java.util.List;

import xyz.cfsaisi.entity.Doctor;
import xyz.cfsaisi.utils.PageUtils;

public interface DoctorDao {

	List<Doctor> findDoctor(String name,String department,PageUtils<Doctor> pUtils);

	int selectAllDoctorCount(String name,String department);

	Doctor selectDoctorById(String id);

	int updateDoctorById(Doctor doctor);

	int insertDoctor(Doctor doctor);

	int deleteDoctor(String[] ids);

	List<Doctor> findAllDoctor();
	
	

}
