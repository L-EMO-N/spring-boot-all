<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no"/>
<title>推荐资讯</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css?v=1.0.9" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/positionNewsPage.css?v=1.0.4" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/positionNewsPage.js?v=1.0.9"></script>
</head>
<body style="height: 100%;">
<a class='font1' onclick="toNewsDetails(this,'{news.news_id}')">
	<table style='width: 100%;border: none;'>
		<tr>
			<td colspan="3">{news.title}</td>
		</tr>
		<tr style="width: 100%" >
			<td style='width: 33.33333%;'>
				<img style='width: 100%;' alt='{news.title}' src='{image}' onerror='error(this)' onload='load(this)' style='display:none'/>
			</td>
		</tr>
		<tr>
			<td colspan='3'>
				<font class='font2'>{news.author}</font>&nbsp;&nbsp;&nbsp;&nbsp;
				<font class='font2'>{news.comment_count}评论</font>&nbsp;&nbsp;&nbsp;&nbsp;
				<font class='font2'>{news.publishTimeStr}</font>
			</td>
		</tr>
	</table>
	<c:forEach items="${newsList}" var="news">
		<a class='font1' onclick="toNewsDetails(this,'${news.news_id}')">
			<c:choose>
				<c:when test="${news.imageArray != null && fn:length(news.imageArray) >= 2 }">
					<table style='width: 100%;border: none;'>
						<tr>
							<td colspan="3">${news.title}</td>
						</tr>
						<tr style="width: 100%" >
						<c:forEach items="${news.imageArray}" var="image">
							<td style='width: 33.33333%;'>
								<img style='width: 100%;' alt='${news.title}' src='${image}' onerror='error(this)' onload='load(this)' style='display:none'/>
							</td>
						</c:forEach>
						</tr>
						<tr>
							<td colspan='3'>
							<font class='font2'>${news.author}</font>&nbsp;&nbsp;&nbsp;&nbsp;
							<font class='font2'>${news.comment_count}评论</font>&nbsp;&nbsp;&nbsp;&nbsp;
							<font class='font2'>${news.publishTimeStr}</font>
							</td>
						</tr>
					</table>
				</c:when>
				<c:when test="${news.imageArray != null && fn:length(news.imageArray) == 1}">
					<table style='width: 100%'>
						<tr>
							<td colspan='2' style='text-align:left;vertical-align:top;'>${news.title}</td>
							<td style='width: 34%;'><img style='width: 100%;' alt='${news.title}' src='${news.imageArray[0]}' onerror='error(this)' onload='load(this)' style='display:none' /></td>
						</tr>
						<tr>
							<td colspan='3'>
							<font class='font2'>${news.author}</font>&nbsp;&nbsp;&nbsp;&nbsp;
							<font class='font2'>${news.comment_count}评论</font>&nbsp;&nbsp;&nbsp;&nbsp;
							<font class='font2'>${news.publishTimeStr}</font>
							</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</a>
		<HR class="hr1">
	</c:forEach>
</body>
</html>