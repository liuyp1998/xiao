package com.xdl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xdl.bean.XdlUser;
import com.xdl.service.XdlUserService;

/**
 * Servlet implementation class XdlUserRegister
 */
public class XdlUserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        String  login_name = request.getParameter("login_name");
        String  password = request.getParameter("password");
        String  email = request.getParameter("email");
        String  recommender = request.getParameter("recommender");
        // 把上面的数据封装成XdlUser
        XdlUser  user = new XdlUser(login_name, password, email, recommender);
        XdlUserService userService = new XdlUserService();
        boolean   res = userService.register(user);
        if(res){
        	// 跳转到 registerOk.jsp
        	response.sendRedirect("registerOk.jsp");
        }else{
        	// 跳回注册页面   并传递注册失败的消息
        	request.setAttribute("msg", "注册失败");
        	request.getRequestDispatcher("register.jsp")
        	    .forward(request, response);
        }
         
	}

}




