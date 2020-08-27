package xyz.cfsaisi.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import xyz.cfsaisi.entity.Doctor;
import xyz.cfsaisi.entity.Medicine;
import xyz.cfsaisi.service.MedicineService;
import xyz.cfsaisi.service.impl.MedicineServiceImpl;
import xyz.cfsaisi.utils.PageUtils;

@WebServlet("/medicine")
@MultipartConfig
public class MedicineServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	private MedicineService mService = new MedicineServiceImpl();

	public void findAllMedicine(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String currentPage = request.getParameter("pageIndex");
		int totalCount = mService.findMedicineCount(name,type);
		PageUtils<Medicine> pUtils = new PageUtils<Medicine>(3, totalCount);
		if (currentPage != null && currentPage != "") {
			pUtils.setCurrentPage(Integer.parseInt(currentPage));
		}
		List<Medicine> list = mService.findMedicine(name, type,pUtils);
		pUtils.setPageList(list);
		request.setAttribute("pUtils", pUtils);
		request.setAttribute("type", type);
		request.setAttribute("name", name);
		request.getRequestDispatcher("medicine/index.jsp").forward(request, response);
	}
	
	public void deleteMedicine(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String ids = request.getParameter("id");
		ids = ids.trim();
		String[] split = ids.split(" ");
		//获取需要删除的数据对应的文件名称
		List<Medicine> mList = mService.findMedicineById(split);
		for (int i = 0; i < mList.size(); i++) {
			if (mList.get(i)!=null) {
				File file = new File("e:/upload/"+mList.get(i).getPicture());
				if (file.exists()) {
					file.delete();
				}
			}
		}
		int row = mService.deleteMedicine(split);
		response.sendRedirect("medicine?method=findAllMedicine");
	}
	
	public void insertMedicine(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String mid = request.getParameter("mid");
		Part part = request.getPart("picture");
		String filename = UUID.randomUUID().toString()+".jpg";
		String inprice = request.getParameter("inPrice");
		String salprice = request.getParameter("salPrice");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		Integer type2 = null;
		if (type != null && type != "") {
			type2 = Integer.parseInt(type);
		}
		String descs = request.getParameter("descs");
		String qualitydate = request.getParameter("qualityDate");
		Integer qualitydate2 = null;
		if (qualitydate != null && qualitydate != "") {
			qualitydate2 = Integer.parseInt(qualitydate);
		}
		String description = request.getParameter("description");
		String produceFirm = request.getParameter("produceFirm");
		String readme = request.getParameter("readme");
		String remark = request.getParameter("remark");
		Medicine medicine = new Medicine(mid, filename, inprice, salprice, name, type2, descs, qualitydate2, description, produceFirm, readme, remark);
		part.write("e:/upload/"+filename);
		int row = mService.insertMedicine(medicine);
		response.sendRedirect("medicine?method=findAllMedicine");
	}
	
	public void lookMedicineById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Medicine medicine = mService.lookMedicineById(id);
		request.setAttribute("me", medicine);
		request.getRequestDispatcher("medicine/look.jsp").forward(request, response);
	}
	public void modifyMedicineById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Medicine medicine = mService.lookMedicineById(id);
		request.setAttribute("me", medicine);
		request.getRequestDispatcher("medicine/edit.jsp").forward(request, response);
	}
	public void updateMedicine(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String mid = request.getParameter("mid");
		String oldpicture = request.getParameter("oldpicture");
		Part part = request.getPart("picture");
		String filename = UUID.randomUUID().toString()+".jpg";
		String inprice = request.getParameter("inPrice");
		String salprice = request.getParameter("salPrice");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		Integer type2 = null;
		if (type != null && type != "") {
			type2 = Integer.parseInt(type);
		}
		String descs = request.getParameter("descs");
		String qualitydate = request.getParameter("qualityDate");
		Integer qualitydate2 = null;
		if (qualitydate != null && qualitydate != "") {
			qualitydate2 = Integer.parseInt(qualitydate);
		}
		String description = request.getParameter("description");
		String produceFirm = request.getParameter("produceFirm");
		String readme = request.getParameter("readme");
		String remark = request.getParameter("remark");
		String temp;
		if (part.getSize()!=0) {
			temp = filename;
			part.write("e:/upload/"+filename);
			//删除数据对应的源图片
			File file = new File("e:/upload/"+oldpicture);
			if (file.exists()) {
				file.delete();
			}
		}else {
			temp = oldpicture;
		}
		Medicine medicine = new Medicine(mid, temp, inprice, salprice, name, type2, descs, qualitydate2, description, produceFirm, readme, remark);
		int row = mService.updateMedicine(medicine);
		response.sendRedirect("medicine?method=findAllMedicine");
	}
}
