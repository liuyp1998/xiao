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
		// ���ݷ���id  ��ȡ�������Ϣ
		XdlCategory  category = xcs.categoryInfoByCategoryId(parent_id);
		request.setAttribute("curr_name", category.getName());
		List<XdlCategory>  categories = xcs.subCategoryList(parent_id);
		request.setAttribute("categories", categories);
		int  current_category_id = -1;
		// ���Ƿ����˵�ǰ����id
		if(s_curr_cid == null){
		    // ȡ�õ�һ���������
		    XdlCategory  firstCategory = 
		    	categories.isEmpty()?null:categories.get(0);
		    //request.setAttribute("firstCategory", firstCategory);
		    current_category_id = firstCategory == null?-1:firstCategory.getCategory_id();
		}else{
			current_category_id = Integer.parseInt(s_curr_cid);
		}
		// ���ݵ�ǰ���� ׼����Ʒ����  ���ҿ��Ƿ�ҳ Ĭ�� �������� print_number ����
		// һҳ��ʾ4�� ��ʾ��һҳ���� 
		XdlProductService   xps = new XdlProductService();
		/*List<XdlProduct>  products = xps.subProductListByCategoryId
			(current_category_id); */
		List<XdlProduct>  products = xps.subProductListByPageInfo(
			current_category_id,"print_number", "desc", 4, 1);
		// ���ݵ�ǰ����id  ��ȡ��ǰ�������
		XdlCategory  curr_category = xcs.categoryInfoByCategoryId
				(current_category_id);
		request.setAttribute("curr_category", curr_category);
		request.setAttribute("products", products);
		request.getRequestDispatcher("book_list.jsp").forward(request, response);
		
	}

}
