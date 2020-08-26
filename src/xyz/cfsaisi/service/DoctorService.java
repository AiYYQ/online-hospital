package xyz.cfsaisi.service;

import java.util.List;

import xyz.cfsaisi.entity.Doctor;
import xyz.cfsaisi.utils.PageUtils;

public interface DoctorService {
	List<Doctor> findDoctor(String name,String department,PageUtils<Doctor> pUtils);

	int findAllDoctorCount(String name,String department);

	Doctor lookDectorById(String id);

	int updateDocterById(Doctor doctor);

	int addDoctor(Doctor doctor);

	int deleteDoctor(String[] ids);

}
