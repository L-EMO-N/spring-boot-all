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
<title>left</title>
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

<style type="text/css">

body{    
	 background-color:#99CCFF;
     background-repeat: repeat-x;    
}

</style>

</head>
<body>
<!-- 
<div id="Layer1" style="position:absolute; left:0px; top:0px; width:100%; height:100%;z-index: -1;position: fixed;">
<img src="../image/bg2.jpg" width="100%" height="100%"/>
</div>
 -->
<ul>
  <li><a href="javascript:doPost('<%=path%>/admin/userinfo',{},'middle')">新增用户统计</a></li><br>
  <li><a href="javascript:doPost('<%=path%>/admin/getVersionList',{},'middle')">版本控制</a></li><br>
  <li><a href="javascript:doPost('<%=path%>/admin/getPmd',{},'middle')">答案职位配置</a></li><br>
  <li><a href="javascript:doPost('<%=path%>/admin/refreshCache',{},'middle')">刷新缓存</a></li><br>
  <li><a href="javascript:doPost('<%=path%>/admin/showC3p0Info',{},'middle')">连接池现在运行情况</a></li><br>
  <li><a href="javascript:doPost('<%=path%>/admin/showC3p0Info',{},'middle')">tomcat运行情况</a></li><br>
  <li><a href="javascript:doPost('<%=path%>/admin/refreshCache',{},'middle')">短信发送情况监控</a></li><br>
  <li><a href="javascript:doPost('<%=path%>/admin/refreshCache',{},'middle')">IP监控</a></li><br>
  <li><a href="javascript:doPost('<%=path%>/admin/refreshCache',{},'middle')">定时器运行情况</a></li><br>
</ul>
</body>
</html>