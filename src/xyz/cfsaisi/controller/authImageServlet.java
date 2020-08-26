package xyz.cfsaisi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.cfsaisi.utils.VerifyCodeUtils;

@WebServlet("/authImage")
public class authImageServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("image/jpg");
		String code = VerifyCodeUtils.generateVerifyCode(4);
		request.getSession().setAttribute("code", code);
		System.out.println(code);
		int w = 115;
		int h = 35;
		VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), code);
	}

	
}
