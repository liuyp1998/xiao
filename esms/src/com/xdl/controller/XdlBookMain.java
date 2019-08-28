package com.xdl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xdl.bean.XdlCategory;
import com.xdl.bean.XdlNews;
import com.xdl.service.XdlCategoryService;
import com.xdl.service.XdlNewsService;

/**
 * Servlet implementation class XdlBookMain
 */
public class XdlBookMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		// 准备好 图书对应的子分类列表
		//List<XdlCategory>  categories = 
		//	new XdlCategoryService().subCategoryList(1);
		// 准备好 图书资讯数据 
		List<XdlNews>  bookNews = new XdlNewsService().subNewsList();
		//request.setAttribute("categories", categories);
		request.setAttribute("bookNews", bookNews);
		// 转发给 book.jsp
		request.getRequestDispatcher("book.jsp").forward(request, response);
	}

}

