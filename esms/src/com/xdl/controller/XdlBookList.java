package com.xdl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xdl.bean.XdlCategory;
import com.xdl.bean.XdlProduct;
import com.xdl.service.XdlCategoryService;
import com.xdl.service.XdlProductService;

/**
 * Servlet implementation class XdlBookList
 */
public class XdlBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
		int  parent_id = Integer.parseInt(request.getParameter("parent_id"));
		String  s_curr_cid = request.getParameter("current_category_id");
		XdlCategoryService  xcs = new XdlCategoryService();
		// 根据分类id  获取分类的信息
		XdlCategory  category = xcs.categoryInfoByCategoryId(parent_id);
		request.setAttribute("curr_name", category.getName());
		List<XdlCategory>  categories = xcs.subCategoryList(parent_id);
		request.setAttribute("categories", categories);
		int  current_category_id = -1;
		// 看是否传入了当前分类id
		if(s_curr_cid == null){
		    // 取得第一个分类对象
		    XdlCategory  firstCategory = 
		    	categories.isEmpty()?null:categories.get(0);
		    //request.setAttribute("firstCategory", firstCategory);
		    current_category_id = firstCategory == null?-1:firstCategory.getCategory_id();
		}else{
			current_category_id = Integer.parseInt(s_curr_cid);
		}
		// 根据当前分类 准备产品数据  并且考虑分页 默认 按照销量 print_number 降序
		// 一页显示4条 显示第一页数据 
		XdlProductService   xps = new XdlProductService();
		/*List<XdlProduct>  products = xps.subProductListByCategoryId
			(current_category_id); */
		List<XdlProduct>  products = xps.subProductListByPageInfo(
			current_category_id,"print_number", "desc", 4, 1);
		// 根据当前分类id  获取当前分类对象
		XdlCategory  curr_category = xcs.categoryInfoByCategoryId
				(current_category_id);
		request.setAttribute("curr_category", curr_category);
		request.setAttribute("products", products);
		request.getRequestDispatcher("book_list.jsp").forward(request, response);
		
	}

}
