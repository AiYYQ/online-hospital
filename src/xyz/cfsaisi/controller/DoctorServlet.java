package xyz.cfsaisi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.cfsaisi.entity.Doctor;
import xyz.cfsaisi.service.DoctorService;
import xyz.cfsaisi.service.impl.DoctorServiceImpl;
import xyz.cfsaisi.utils.PageUtils;

@WebServlet("/doctor")
public class DoctorServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	private DoctorService doctorService = new DoctorServiceImpl();

	public void findAllDoctor(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String currentPage = request.getParameter("currentPage");
		int totalCount = doctorService.findAllDoctorCount(name,department);
		PageUtils<Doctor> pUtils = new PageUtils<>(3, totalCount);
		if (currentPage!=null && currentPage != "") {
			pUtils.setCurrentPage(Integer.parseInt(currentPage));
		}
		List<Doctor> list = doctorService.findDoctor(name,department,pUtils);
		pUtils.setPageList(list);
		//request.setAttribute("list", list);
		request.setAttribute("pUtils", pUtils);
		request.setAttribute("department", department);
		request.setAttribute("name", name);
		request.getRequestDispatcher("doctor/index.jsp").forward(request, response);
	}
	
	public void lookDoctorById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Doctor doctor = doctorService.lookDectorById(id);
		request.setAttribute("doctor", doctor);
		request.getRequestDispatcher("doctor/look.jsp").forward(request, response);
	}
	public void modifyDoctorById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Doctor doctor = doctorService.lookDectorById(id);
		request.setAttribute("d", doctor);
		request.getRequestDispatcher("doctor/edit.jsp").forward(request, response);
	}
	public void updateDoctorById(HttpServletRequest request,HttpServletResponse response) throws NumberFormatException, ParseException, IOException {
		String did = request.getParameter("did");
		String name = request.getParameter("name");
		String cardno = request.getParameter("cardno");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		String education = request.getParameter("education");
		String remark = request.getParameter("remark");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Doctor doctor = new Doctor(Integer.parseInt(did),name,cardno,phone,Integer.parseInt(sex),Integer.parseInt(age),sdf.parse(birthday),email,Integer.parseInt(department),Integer.parseInt(education),remark);
		int row = doctorService.updateDocterById(doctor);
		if (row > 0) {
			response.sendRedirect("doctor?method=findAllDoctor");
		}else {
			response.sendRedirect("doctor?method=findAllDoctor");
		}
	}
	
	public void insertDoctor(HttpServletRequest request,HttpServletResponse response) throws NumberFormatException, ParseException, IOException {
		String name = request.getParameter("name");
		String cardno = request.getParameter("cardno");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		String education = request.getParameter("education");
		String remark = request.getParameter("remark");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Doctor doctor = new Doctor(null,name,cardno,phone,Integer.parseInt(sex),Integer.parseInt(age),sdf.parse(birthday),email,Integer.parseInt(department),Integer.parseInt(education),remark);
		int row = doctorService.addDoctor(doctor);
		response.sendRedirect("doctor?method=findAllDoctor");
	}
	
	public void deleteDoctor(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String ids = request.getParameter("id");
		ids = ids.trim();
		String[] split = ids.split(" ");
		int row = doctorService.deleteDoctor(split);
		response.sendRedirect("doctor?method=findAllDoctor");
	}
}
