<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no"/>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css?v=1.0.1" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/news_details.css?v=1.0.1" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/news_details.js?v=1.0.1"></script>

</head>
<body style="padding-left: 1rem;padding-right: 0.15rem;">

	<c:if test="${newsContent == null}">
		<br/><br/><br/><br/><br/><br/><br/>
		<h2 align="center"><font style="color: red;text-align: center;">抱歉！内容已被删除</font></h2>
		<input id="is_collect" type="hidden" value="0">
	</c:if>
	
	<c:if test="${newsContent != null}">
		<input id="is_collect" type="hidden" value="${newsContent.is_collect}">
		<h2>${newsContent.title}</h2>
			<div class="div_img" >
				<img src="${newsContent.author_url}" />
			</div>
			<div class="div_author">
				<div class="author"><strong>${newsContent.author}</strong></div>
				<div class="time_cmt">${newsContent.publishTimeStr}&nbsp;&nbsp;&nbsp;&nbsp;<font style="color: red">${newsContent.comment_count}评论</font></div>
			</div>
			<br/>
			<br/>
		<div id="content" style="width: 100%;margin-top: 0.4rem">
			${newsContent.content}
		</div>
	</c:if>
</body>
	
</html>