package xyz.cfsaisi.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("method");
		if (param!=null && param != "") {
			Class<? extends BaseServlet> clazz = this.getClass();
			try {
				Method method = clazz.getMethod(param, HttpServletRequest.class,HttpServletResponse.class);
				try {
					method.invoke(this, request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("方法未找到");
		}
	}

}
