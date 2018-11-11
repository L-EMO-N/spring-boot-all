<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
           
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
	table.hovertable tr2 {
		background-color:#a9c6c9;
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

<script type="text/javascript">

</script>

</head>
<body >
<div style="position: fixed;z-index:2;">
	<h3>你吃了吗？</h3>
</div>
<div style="top:78px;z-index:1;" >
	<table class="hovertable" align="center" width="90%" >

	<tr>
		<th style="width: 50%">职位</th>
		<th style="width: 50%">匹配值</th>
	</tr>
	<c:forEach items="${positionList }" var="position" varStatus="status">
		<tr <c:if test="${status.index%2==1}">style="background-color:#F0FFFF"</c:if>>
			<td style="width: 50%" >${position.position_id}${position.position_name}</td>
			<td style="width: 50%" ><input type="text"></td>
		</tr>
		
	</c:forEach>
	</table>
</div>

</body>
</html>