package xyz.cfsaisi.service.impl;

import java.util.List;

import xyz.cfsaisi.dao.MedicineDao;
import xyz.cfsaisi.dao.impl.MedicineDaoImpl;
import xyz.cfsaisi.entity.Medicine;
import xyz.cfsaisi.service.MedicineService;
import xyz.cfsaisi.utils.PageUtils;

public class MedicineServiceImpl implements MedicineService {

	private MedicineDao mDao = new MedicineDaoImpl();
	
	@Override
	public int findMedicineCount(String name, String type) {
		return mDao.findMedicineCount(name,type);
	}

	@Override
	public List<Medicine> findMedicine(String name, String type, PageUtils<Medicine> pUtils) {
		return mDao.findMedicine(name,type,pUtils);
	}

}
