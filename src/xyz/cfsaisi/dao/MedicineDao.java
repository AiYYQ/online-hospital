package xyz.cfsaisi.dao;

import java.util.List;

import xyz.cfsaisi.entity.Medicine;
import xyz.cfsaisi.utils.PageUtils;

public interface MedicineDao {

	int findMedicineCount(String name, String type);

	List<Medicine> findMedicine(String name, String type, PageUtils<Medicine> pUtils);

}
