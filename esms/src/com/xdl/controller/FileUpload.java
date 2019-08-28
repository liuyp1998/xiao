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
		// ����һ�������ļ���Ŀ��������
		DiskFileItemFactory   dfif = new DiskFileItemFactory();
		// servlet �ļ��ϴ����� ����Ҫ �����ļ���Ŀ�������� ���� request
		ServletFileUpload  sfu = new ServletFileUpload(dfif);
		try {
			// ����� ��������֮�������
			List<FileItem> datas = sfu.parseRequest(request);
			for(FileItem fi : datas){
				// �ж�����ͨ���� �����ļ����� 
				if(fi.isFormField()){
					// ������ͨ����
					System.out.println(fi.getFieldName()+":"+fi.getString());
				}else{
					// �����ļ����� 
					System.out.println(fi.getFieldName()+":"+fi.getName() + 
						":" + fi.getSize() );
					// ��ȡ�ļ��е���ʵ·�� 
					String path = request.getServletContext().getRealPath("datas");
					System.out.println("path="+path);
					// ��ֹ�����ļ��� �ļ������Ȳ�һ��  ����
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
						// ������д�����
						fi.write(file);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// ת���� show.jsp ����ʾͼ�� 
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
