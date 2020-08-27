package xyz.cfsaisi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.cfsaisi.entity.Doctor;
import xyz.cfsaisi.entity.Register;
import xyz.cfsaisi.service.DoctorService;
import xyz.cfsaisi.service.RegisterService;
import xyz.cfsaisi.service.impl.DoctorServiceImpl;
import xyz.cfsaisi.service.impl.RegisterServiceImpl;
import xyz.cfsaisi.utils.PageUtils;

@WebServlet("/register")
public class RegisterServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	private RegisterService rService = new RegisterServiceImpl();
	private DoctorService dService = new DoctorServiceImpl();
	
	public void findAllRegister(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("rid");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String currentPage = request.getParameter("currentPage");
		int totalCount = rService.findAllRegisterCount(rid,name,department);
		PageUtils<Register> pUtils = new PageUtils<>(3, totalCount);
		if (currentPage!=null && currentPage != "") {
			pUtils.setCurrentPage(Integer.parseInt(currentPage));
		}
		List<Register> list = rService.findRegister(rid,name,department,pUtils);
//		for (int i = 0; i < list.size(); i++) {
//			Register register = list.get(i);
//			String did = register.getDid();
//			Doctor doctor = dService.lookDectorById(did);
//			list.get(i).setDoctor(doctor);
//		}
		pUtils.setPageList(list);
		request.setAttribute("pUtils", pUtils);
		request.setAttribute("department", department);
		request.setAttribute("name", name);
		request.setAttribute("rid", rid);
		request.getRequestDispatcher("register/index.jsp").forward(request, response);
	}
	
	public void lookRegister(HttpServletRequest request,HttpServletResponse response) {
		String rid = request.getParameter("id");
		String flag = request.getParameter("flag");
		Register register = rService.findRegisterById(rid);
		Doctor doctor = dService.lookDectorById(register.getDid());
		register.setDoctor(doctor);
		request.setAttribute("re", register);
		if ("true".equals(flag)) {
			try {
				request.getRequestDispatcher("register/look.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				List<Doctor> list = dService.findAllDoctor();
				request.setAttribute("doctors", list);
				request.getRequestDispatcher("register/edit.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateRegister(HttpServletRequest request,HttpServletResponse response) {
		
	}
}
