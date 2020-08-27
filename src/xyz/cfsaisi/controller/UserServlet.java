package xyz.cfsaisi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.NEW;

import xyz.cfsaisi.entity.User;
import xyz.cfsaisi.service.UserService;
import xyz.cfsaisi.service.impl.UserServiceImpl;

@WebServlet("/user")
public class UserServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
	public void checkUsername(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username");
		User user = userService.checkUsername(username);
		if (user!=null) {
			try {
				response.getWriter().print(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				response.getWriter().print(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void checkEmail(HttpServletRequest request,HttpServletResponse response) {
		String email = request.getParameter("email");
		User user = userService.checkEmail(email);
		if (user!=null) {
			try {
				response.getWriter().print(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				response.getWriter().print(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void regist(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setUsername(username);
		user.setEmail(email);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			String date = sdf.format(new Date());
			System.out.println(date);
			user.setModifytime(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean bool = userService.regist(user);
		try {
			response.getWriter().print(bool);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void checkCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String parameter = request.getParameter("verify");
		String code = (String)request.getSession().getAttribute("code");
		PrintWriter writer = response.getWriter();
		if (code!=null) {
			if (code.equalsIgnoreCase(parameter)) {
				writer.print(false);
			}else {
				writer.print(true);
			}
		}else {
			writer.print(true);
		}
	}
	
	public void checkLogin(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.checkLogin(username,password);
		if (user != null) {
			try {
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.invalidate();
		response.sendRedirect("login.jsp");
	}
}
