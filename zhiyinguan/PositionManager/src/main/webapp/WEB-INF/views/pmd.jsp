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

function ShowModalDialog(url, arg) {
	alert("1");
    var iframe = document.getElementById("postiframe");
    if (!iframe) {
        iframe = document.createElement("iframe");
        iframe.id = "postiframe";
        iframe.name = "postiframe";
        iframe.frameborder = "0";
        iframe.style.width = "500px";
        iframe.style.height = "400px";
    }
    alert("2");
    var myForm = document.createElement("form");
    myForm.id = "formtosubmit";
    myForm.method = "post";  //使用post方式提交
    myForm.action = url + "&isDlg=1"; //以dialog方式打开
    alert("3");
    myForm.target = iframe.id;
   
    var dataInput = document.createElement("input");
    dataInput.setAttribute('type', "hidden");
    dataInput.name = "bigData";
    dataInput.value = arg;  //将值赋予这个隐藏的field
    var submitInput = document.createElement("input");
    submitInput.setAttribute('type', "submit");
   
    myForm.appendChild(dataInput);
    
    myForm.appendChild(submitInput);
    document.body.appendChild(myForm);
    alert("4");
    
    var options = {
        url: url,
        html:iframe,
        tite: '',
        width: 500,
        height: 400
    };
    alert("5");
    
    showModalDialog(options);
    alert("6");
    myForm.submit();
    alert("7");
    document.body.removeChild(myForm);
}

showModelessDialog('/zhiyinguan/admin/getAllMatchPosition?a='+new Date(),'脚本之家','dialogWidth:800px;dialogHeight:600px; dialogLeft:200px;dialogTop:150px;center:yes;help:yes;resizable:yes;status:yes') ;






</script>



</head>
<body >

<table class="hovertable" align="center" width="90%" >

	<tr>
		<th align="center" style="width: 10%">问题</td>
		<th align="center" style="width: 20%">答案内容</td>
		<th align="center" style="width: 70%">匹配规则</td>
	</tr>
	
	<c:forEach items="${questionList }" var="question" varStatus="status">
		<tr <c:if test="${status.index%2==1}">style="background-color:#F0FFFF"</c:if>>
			<td style="width: 10%" rowspan="${question.answers.size()+1}">${question.question_id}、${question.question_content}<br/>(${question.type==1?"单":"多"}选题)</td>
		</tr>
			<c:forEach items="${question.answers}" var="answer">
			<tr <c:if test="${status.index%2==1}">style="background-color:#F0FFFF"</c:if>>
				<input type="hidden" value="${answer.answer_id}">
				<td style="width: 20%">${answer.answer_content}</td>
				<td style="width: 70%"><input type="text" value="${answer.position_match_degree}"></td>
			</tr>
			</c:forEach>
		
	</c:forEach>


</body>
</html>