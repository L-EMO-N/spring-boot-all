<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/news.css?v=1.0.8" />
</head>
<body style="height: 100%">

<div id="wrapper">
	<div id="scroller">
		<div id="pullDown">
			<span class="pullDownLabel">下拉刷新</span>
		</div>
		<ul id="thelist" style="width: 100%;text-align: left;padding-left: 1rem;padding-right: 1rem;padding-top: 0.3rem;padding-bottom: 0.3rem">
			<!--<li>原始数据</li>-->
		</ul>
		<div id="pullUp">
			<span class="pullUpLabel">上拉加载更多</span>
		</div>
	</div>
</div>

<script type="text/javascript">
	var url = '../news/getNewsHotData';
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/iscroll.js?v=1.0.9"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js?v=1.0.9"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js?v=1.0.0"></script>

</body>
</html>