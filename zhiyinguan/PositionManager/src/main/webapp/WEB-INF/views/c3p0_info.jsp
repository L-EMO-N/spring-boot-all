<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="com.mchange.v2.c3p0.ComboPooledDataSource"%>
<%@ page import="com.keyia.zhiyinguan.cache.DataCache"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ssm</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<%
WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());    
com.mchange.v2.c3p0.ComboPooledDataSource ds = (com.mchange.v2.c3p0.ComboPooledDataSource)wac.getBean("dataSource");
%>
  </head>
  <body>
	  <h1 align="center">------------c3p0连接池链接状态--------------</h1>
	  <h3 align="center">c3p0连接池中 【总共】 连接数量：<%= ds.getNumConnectionsDefaultUser() %></h3>
	  <h3 align="center">c3p0连接池中 【忙】 连接数量：<%= ds.getNumBusyConnectionsDefaultUser() %></h3>
	  <h3 align="center">c3p0连接池中 【空闲】 连接数量：<%= ds.getNumIdleConnectionsDefaultUser() %></h3>
	  <h3 align="center">c3p0连接池中 【未关闭】 连接数量：<%= ds.getNumUnclosedOrphanedConnectionsAllUsers() %></h3>
	  
  </body>
</html>
