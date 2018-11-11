<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  		<br/>
  		<br/>
  		<br/>
  		<br/>
  		<h3  align="center">职引官后台管理系统</h3>
  
  	<div align="center">
  	<form action="<%=path%>/admin/login" method="post">
		用户:<input name="userName" type="text" value="admin" readonly="readonly"><br><br>
		密码:<input name="password" type="password"><br><br>
		<input type="submit" value="登录">
	</form>
	</div>
  </body>
</html>
