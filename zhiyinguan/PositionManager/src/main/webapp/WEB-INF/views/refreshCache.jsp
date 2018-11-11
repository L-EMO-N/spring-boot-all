<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
 <!--<a href="javascript:doPost("addStudent.action", {"name":"张三"})">提交</a> -->
	function doPost(to, p,t) {  // to:提交动作（action）,p:参数  
		var myForm = document.createElement("form");       
		myForm.method = "post";  
		myForm.action = to;
		myForm.target = t;
		for (var i in p){      
			var myInput = document.createElement("input");       
			myInput.setAttribute("name", i);  // 为input对象设置name  
			myInput.setAttribute("value", p[i]);  // 为input对象设置value  
			myForm.appendChild(myInput);  
		}     
		document.body.appendChild(myForm);     
		myForm.submit();   
		document.body.removeChild(myForm);  // 提交后移除创建的form  
	}  


</script>
</head>



<body>  <br/><br/><br/>
		<h2>${info}</h2>
		<br/><br/><br/>
<ul>
  <li><a href="javascript:doPost('<%=path%>/admin/refreshCheckUpdate',{},'middle')">刷新版本控制</a></li><br>
  <li><a href="javascript:doPost('<%=path%>/admin/refreshQuestion',{},'middle')">刷新问题数据</a></li><br>
  <li><a href="javascript:doPost('<%=path%>/admin/refreshPositionNames',{},'middle')">刷新职位数据</a></li><br>
</ul>



</body>
</html>