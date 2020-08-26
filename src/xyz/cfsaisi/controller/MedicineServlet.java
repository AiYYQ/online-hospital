package xyz.cfsaisi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.cfsaisi.entity.Medicine;
import xyz.cfsaisi.service.MedicineService;
import xyz.cfsaisi.service.impl.MedicineServiceImpl;
import xyz.cfsaisi.utils.PageUtils;

@WebServlet("/medicine")
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
}
