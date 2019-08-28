package com.xdl.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.xdl.bean.XdlUser;
import com.xdl.util.Md5Util;

/**
 * Servlet implementation class FileUpload
 */
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		// 构建一个磁盘文件条目工厂对象
		DiskFileItemFactory   dfif = new DiskFileItemFactory();
		// servlet 文件上传对象 中需要 磁盘文件条目工厂对象 解析 request
		ServletFileUpload  sfu = new ServletFileUpload(dfif);
		try {
			// 这就是 经过解析之后的数据
			List<FileItem> datas = sfu.parseRequest(request);
			for(FileItem fi : datas){
				// 判断是普通数据 还是文件数据 
				if(fi.isFormField()){
					// 这是普通数据
					System.out.println(fi.getFieldName()+":"+fi.getString());
				}else{
					// 这是文件数据 
					System.out.println(fi.getFieldName()+":"+fi.getName() + 
						":" + fi.getSize() );
					// 获取文件夹的真实路径 
					String path = request.getServletContext().getRealPath("datas");
					System.out.println("path="+path);
					// 防止中文文件名 文件名长度不一致  重名
					XdlUser  user = (XdlUser)request.getSession().getAttribute("user");
					String  userName = "weijie";
					if(user != null){
						 userName = user.getLogin_name();
					}
					String   oriName = fi.getName();
					String   suffix = oriName.substring(oriName.lastIndexOf("."));
					System.out.println("suffix="+suffix);
					String  fileName = userName + System.currentTimeMillis() 
					   + Md5Util.md5Str(fi.getName()) + suffix;
					String  filePath = path + "/" + fileName;
					File file  = new File(filePath);
				
					try {
						// 把数据写入磁盘
						fi.write(file);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 转发到 show.jsp 来显示图书 
					request.setAttribute("imgPath", "datas/"+fileName);
					request.getRequestDispatcher("show.jsp")
					  .forward(request, response);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
