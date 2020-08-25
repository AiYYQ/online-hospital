package xyz.cfsaisi.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		}
	}
}
