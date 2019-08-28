package com.xdl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xdl.bean.XdlCategory;
import com.xdl.service.XdlCategoryService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class XdlCategoryListAJAX
 */
public class XdlCategoryListAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 准备一份分类列表数据 
		XdlCategoryService  xcs = new XdlCategoryService();
		List<XdlCategory>  categories = xcs.subCategoryList(1);
		String  jsonStr = JSONArray.fromObject(categories).toString();
		PrintWriter  pw = response.getWriter();
		pw.write(jsonStr);
		pw.close();
	}

}
