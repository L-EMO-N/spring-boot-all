<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String token = ""+Math.random();
session.setAttribute("token", token);
%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>版本管理</title>

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
}
.font{width:200px; text-align:left; font-size:20px;}

.font1{width:200px; text-align: center; font-size:20px;}

textarea{vertical-align:top;text-align:left;  } 

</style>

<script type="text/javascript">
function update() { 
	var msg = "确定修改吗"; 
	if (confirm(msg)==true){ 
		document.getElementById('update_content1').value=document.getElementById('update_content_temp1').value;
		return true; 
	}else{ 
		return false; 
	} 
} 

function addCheckUpdate(){
	var msg = "确定新增吗，新增会使当前版本的失效，新增的版本将成为当前版本"; 
	if (confirm(msg)==true){ 
		document.getElementById('update_content2').value=document.getElementById('update_content_temp2').value;
		return true; 
	}else{ 
		return false; 
	} 
}

var i = 1;
function addNew(){
	if(i==0){
		document.getElementById('newtable').style.display='none';
		i=1;
	}else{
		document.getElementById('newtable').style.display='';
		i=0;
	}
}


</script>

</head>
<body >

	<div style="width:100%;text-align:center">
			<font size="3" color="red">${info}</font>
	</div>
	
	<br/><br/>
	<h3 align="center">当前版本</h3>
	<table   class="hovertable" align="center" width="90%" >
	
	<tr>
		<th align="center">版本id</td>
		<th align="center">版本号</td>
		<th align="center">更新内容</td>
		<th align="center">是否强制更新</td>
		<th align="center">更新地址</td>
		<th align="center">修改</td>
	</tr>
	
	<tr>
		<form action="<%=path%>/admin/updateCheckUpdate" method="post">
		<td align="center" width="5%">
			${checkUpdate.cp_id}
			<input type="hidden" name="cp_id" value="${checkUpdate.cp_id}">
			<input type="hidden" name="token" value="${token}">
		</td>
		
		<td align="center" width="10%">
			<input type="text" value="${checkUpdate.version_number}" name="version_number">
		</td>
		
		<td align="center" width="30%">
			<textarea id="update_content_temp1" style='height:100px;width:80%;text-align:left;' >${checkUpdate.update_content}</textarea>
			<input id="update_content1" type="hidden" name="update_content" value="${checkUpdate.update_content}">
		</td>
		
		<td align="center" width="15%">
		<select id="select" name="update_level">
		  <option value ="0">提示用户更新</option>
		  <option value ="1">强制用户更新</option>
		</select>
		<script type="text/javascript">  
         	document.getElementById("select").value="${checkUpdate.update_level}";  
        </script>  
		</td>
		
		<td align="center" width="20%">
			<input type="text" name="download_link" value="${checkUpdate.download_link}" style="width:80%">
		</td>
		
		<td align="center" width="10%">
			<input type="submit" value="修改" onclick="javascript:return update();">
		</td>
		</form>
	</tr>
	</table>
	
	<br/><br/>
	<div style="width:100%;text-align:center">
		<button onclick="addNew()" style="align:center">新增版本</button>
	</div>
	<br>
	
	<table  id="newtable" class="hovertable" align="center" width="90%" style="display:none">
	
	<tr>
		<th align="center">版本号</td>
		<th align="center">更新内容</td>
		<th align="center">是否强制更新</td>
		<th align="center">更新地址</td>
		<th align="center">修改</td>
	</tr>
	
	<tr>
		<form action="<%=path%>/admin/addCheckUpdate" method="post">
		
		<td align="center" width="10%">
			<input type="text" value="" name="version_number">
			<input type="hidden" name="token" value="${token}">
		</td>
		
		<td align="center" width="30%">
			<textarea id="update_content_temp2" style='height:100px;width:80%;text-align:left;'></textarea>
			<input id="update_content2" type="hidden"  name="update_content">
		</td>
		
		<td align="center" width="15%" >
		<select id="select" name="update_level">
		  <option value ="0">提示用户更新</option>
		  <option value ="1">强制用户更新</option>
		</select>
		</td>
		
		<td align="center" width="20%">
			<input type="text" value="" style="width:80%" name="download_link">
		</td>
		
		<td align="center" width="10%">
			<input type="submit" value="新增" onclick="javascript:return addCheckUpdate();">
		</td>
		</form>
	</tr>
	</table>
	
	<h3 align="center">历史版本</h3>
	<table   class="hovertable" align="center" width="90%" >
	
	<tr>
		<th align="center">版本id</td>
		<th align="center">版本号</td>
		<th align="center">更新内容</td>
		<th align="center">是否强制更新</td>
		<th align="center">更新地址</td>
	</tr>
	<c:forEach var="checkUpdate" items="${cuList}">
		<tr>
			<td width="10%" align="center">${checkUpdate.cp_id}</td>
			<td width="15%" align="center">${checkUpdate.version_number}</td>
			<td width="40%" align="center">${checkUpdate.update_content}</td>
			<td width="15%" align="center">${checkUpdate.update_level==0?"提示用户更新":"强制用户更新"}</td>
			<td width="20%" align="center">${checkUpdate.download_link}</td>
		</tr>
	
	</c:forEach>
	
	</table>

</body>
</html>