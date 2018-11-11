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
<title>Insert title here</title>

<style type="text/css">
body{    
	 background-color:#99CCFF;
     background-repeat: repeat-x;    
}
</style>

<script type="text/javascript">
 <!--<a href="javascript:doPost("addStudent.action", {"name":"张三"})">提交</a> -->
	function doPost(to, p,t) {  // to:提交动作（action）,p:参数  
		if (confirm("确定退出登录吗")==true){ 
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
		}else{
			
		} 
		
	}  


</script>

</head>
<body >
	<h1 style="text-align: center;color: white; ">职引官后台管理系统</h1>
	<li><a href="javascript:doPost('<%=path%>/admin/logout',{},'_top')" style="position: fixed;color: red;position: absolute; bottom: 10px; right: 50px;">退出</a></li>
	
</body>
	
</html>