<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h3> 文件上传 </h3>
<form action="upload.do"  method="post"  enctype="multipart/form-data">
     账号:<input  type="text"  name="login_name"> <br>
     密码:<input  type="password"  name="password"> <br>
     头像: <input  type="file"  name="head_img" > <br>
  <input  type="submit"  value="提交">
</form>
</body>
</html>


