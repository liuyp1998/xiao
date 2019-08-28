package com.xdl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xdl.bean.XdlProduct;
import com.xdl.service.XdlProductService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class XdlProductListAJAX
 */
public class XdlProductListAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XdlProductListAJAX() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取ajax 发送的 5 个参数 
		response.setContentType("text/html;charset=utf-8");
		int  category_id = Integer.parseInt(request.getParameter("category_id"));
		String  orderStd = request.getParameter("orderStd");
		String  orderType = request.getParameter("orderType");
		int  pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int  pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		// 构建一个Service 对象 
		XdlProductService  xps  = new XdlProductService();
		List<XdlProduct> datas = xps.subProductListByPageInfo(category_id, 
			orderStd, orderType, pageSize, pageNumber);
	    String  jsonStr = JSONArray.fromObject(datas).toString();
	    PrintWriter  pw = response.getWriter();
	    pw.write(jsonStr);
	    pw.close();
	}



}
