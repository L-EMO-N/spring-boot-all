<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
           
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	table.hovertable {
		font-family: verdana,arial,sans-serif;
		font-size:11px;
		color:#333333;
		border-width: 1px;
		border-color: #999999;
		border-collapse: collapse;
	}
	table.hovertable th {
		background-color:#c3dde0;
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #a9c6c9;
	}
	table.hovertable tr {
		background-color:#d4e3e5;
	}
	table.hovertable td {
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #a9c6c9;
		text-align: center;
	}
	.font{width:200px; text-align:left; font-size:20px;}

	.font1{width:200px; text-align: center; font-size:20px;}
	
</style>
</head>
<body>

<h2 align="center">每日新增用户统计</h2>
<br>
<br>

<div align="right" style="width: 90%" >
	<form action="<%=path%>/admin/userinfo" method="post">
	 日期: <input name="rq" type="text" value="${rq}"/><input type="submit" value="查询"/>
	 </form>
</div>

<br>
<br>
<br>

<table class="hovertable" align="center" width="90%" >
	<tr>
		<th align="center">日期</td>
		<th align="center">新增人数</td>
	</tr>
	
<c:forEach items="${mapList}" var="map" > 
	<tr>
	    <c:forEach items="${map}" var="entry"> 
	       <c:if test="${entry.key == 'create_time'}">
	            <td>
	       		${entry.value}
	       		</td>
	       </c:if>
	       <c:if test="${entry.key == 'num'}">
	       		<td>
	       		<a href="#">${entry.value}</a>
	       		</td>
	       </c:if>
	    </c:forEach>
	 </tr>
</c:forEach> 

</table>


	

</body>
</html>