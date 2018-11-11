<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
	function setColor(){
	  var r = Math.floor((Math.random() * 256)).toString(16);
	  var g = Math.floor((Math.random() * 256)).toString(16);
	  var b = Math.floor((Math.random() * 256)).toString(16);

	  var colorString = "#" + r + g + b;
	  document.write("<body bgcolor='#ff00ff' ></body>");
	  document.close();
	 }


</script>

<frameset rows="20%,*" name="frameset" border="1" bordercolor="#009966">
	<frame name="top" src="<%=path%>/admin/top">
	<frameset cols="20%,*">
	    <frame name="left" src="<%=path%>/admin/left">
	    <frame name="middle" src="<%=path%>/admin/middle">
	</frameset>
</frameset>
