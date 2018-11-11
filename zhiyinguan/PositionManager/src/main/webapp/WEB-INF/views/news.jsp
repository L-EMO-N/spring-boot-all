<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- width为设备宽度,初始，最大，最小缩放比例都为1，不允许用户手动缩放 -->
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<!-- 删除黙认的苹果菜单栏和工具栏,如需要苹果菜单栏和工具栏可不加 -->
<meta name="apple-mobile-web-app-capable" content="yes" />
<!-- 控制状态栏样式content有三个值：default、black、black-translucent -->
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<!-- 在手机中不会将网页中的一串数字(电话号码)显示为拨号的超链接,默认telephone=yes-->
<meta name="format-detection" content="telephone=no"/>

<title>Insert title here</title>

<style type="text/css">
	a:link {text-decoration: none;}
	a:visited {text-decoration: none;}
	a:hover{text-decoration: none;}
	a:active {text-decoration: none;}
	.hr1{ height:0.5px;border:none;border-top:0.5px solid #C0C0C0;}
	.font1{font-weight: normal;font-size:16px;color: #333333;}
	.font2{font-size:10px;color: #808080;}
</style>

<script type="text/javascript">

	function load(ts){
		//alert("onload");
		ts.style.display = 'block';  //显示图片
		ts.height=200;
		//alert(ts.readyState);
	}

	function error(ts){
		//ts.height=1;
		style='display:none'
		alert("err");
		
	}
	
	 function getDocumentTop() { 
	     var scrollTop = 0, bodyScrollTop = 0, documentScrollTop = 0; 
	     if (document.body) { 
	         bodyScrollTop = document.body.scrollTop; 
	     } 
	     if (document.documentElement) { 
	         documentScrollTop = document.documentElement.scrollTop; 
	     } 
	     scrollTop = (bodyScrollTop - documentScrollTop > 0) ? bodyScrollTop : documentScrollTop;    return scrollTop; 
	 } 

	   

	 //可视窗口高度 

	 function getWindowHeight() { 
	     var windowHeight = 0;    if (document.compatMode == "CSS1Compat") { 
	         windowHeight = document.documentElement.clientHeight; 
	     } else { 
	         windowHeight = document.body.clientHeight; 
	     } 
	     return windowHeight; 
	 } 

	 //滚动条滚动高度 
	 function getScrollHeight() { 
	     var scrollHeight = 0, bodyScrollHeight = 0, documentScrollHeight = 0; 
	     if (document.body) { 
	         bodyScrollHeight = document.body.scrollHeight; 
	     } 
	     if (document.documentElement) { 
	         documentScrollHeight = document.documentElement.scrollHeight; 
	     } 
	     scrollHeight = (bodyScrollHeight - documentScrollHeight > 0) ? bodyScrollHeight : documentScrollHeight;    return scrollHeight; 
	 }
	 var isRequest = false;
	 window.onscroll = function () { 
		     //监听事件内容 
		    if(getScrollHeight() <= getWindowHeight() + getDocumentTop() + 200){ 
		        //当滚动条到底时,这里是触发内容 
		         //异步请求数据,局部刷新dom 
		         if(isRequest == false){
		        	 alert(111);
		        	 isRequest = true;
		         }
		     } 
	 }
		 



</script>
</head>

<body>
	<table border="0" style="width: 100%">
	<c:forEach items="${newsList}" var="news">
		<tr>
			<td>
				<a href="<%=basePath%>news/getNewsDetails/${news.news_id}">
					<table style="width: 100%">
						<tr>
							<td colspan="3">
								<font class="font1">${news.title}</font>
							</td>
						</tr>
						<tr style="width: 100%" >
						<c:forEach items="${news.imageArray}" var="image">
							<td style="width: 30%;">
								<img  style="width: 100%;height: 62%" alt="${news.title}" src="${image}" onerror="error(this)" onload="load(this)" style='display:none' />
							</td>
						</c:forEach>
						<tr>
							<td>
								<font class="font2">${news.author}</font>
							</td>
							<td colspan="2">
								<font class="font2">${news.time}</font>
							</td>
						</tr>
					</table>
				</a>
			</td>
		</tr>
		<tr>
			<td>
				<HR class="hr1">
			</td>
		</tr>
	</c:forEach>
	</table>
	
	
	<a href="<%=basePath%>news/getNewsDetails/${news.news_id}">
					<table style="width: 100%">
						<tr>
							<td colspan="2">
								<font class="font1">${news.title}</font>
							</td>
							<td colspan="1">
								<font class="font1">${news.title}</font>
							</td>
						</tr>
							<td>
								<font class="font2">${news.author}</font>
							</td>
							<td colspan="2">
								<font class="font2">${news.time}</font>
							</td>
						</tr>
					</table>
				</a>

</body>
	
</html>