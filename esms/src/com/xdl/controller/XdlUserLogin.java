package com.xdl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xdl.bean.XdlUser;
import com.xdl.service.XdlUserService;

/**
 * Servlet implementation class XdlUserLogin
 */
public class XdlUserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String  login_name = request.getParameter("login_name");
		String  password = request.getParameter("password");
		XdlUserService  xus = new XdlUserService();
		XdlUser  user = xus.login(login_name, password);
		if(user != null){
			request.getSession().setAttribute("user", user);
			//response.sendRedirect("book.jsp");
			response.sendRedirect("bookMain.do");
		}else{
			request.setAttribute("msg", "”√ªß√˚√‹¬Î¥ÌŒÛ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}




