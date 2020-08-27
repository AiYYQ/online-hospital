package xyz.cfsaisi.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.cfsaisi.entity.User;

public class MyFilter implements Filter{
	
	private List<String> list = new ArrayList<String>();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		list.add("/user");
		list.add("/login.jsp");
		list.add("/regist.jsp");
		list.add("/*.html");
		list.add("/*.js");
		list.add("/*.css");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		if (servletPath != null && list.contains(servletPath)) {
			chain.doFilter(request, response);
			return;
		}
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			chain.doFilter(request, response);
			return;
		}
		response.sendRedirect("login.jsp");
	}

}
