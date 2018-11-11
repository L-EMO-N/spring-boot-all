<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no"/>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css?v=1.0.2" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js?v=1.0.0"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/css3-mediaqueries.js?v=1.0.0"></script>

<style type="text/css">

* {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

body {font-size:1.8rem;}
hr{height:0.1rem;border:none;background-color: #F1F1F1}


#left
{
    background: #ffffff;
    float: left;
    width: 47%;
}
#center
{
    background: #ffffff;
    float: left;
    width: 6%;
}
#right
{
    background: #ffffff;
    float: right;
    width: 47%;
}

td
{
	vertical-align: middle;
	text-align: center;
	font-size: 1.3rem;
	background-color: #ffffff;
	padding: 0.8rem;
	color: #333333;
	
}
th
{
	width:33.33%;
	vertical-align: middle;
	text-align: center;
	font-size: 1.4rem;
	padding-bottom: 0.5rem;
	
}


</style>
</head>
<body style="margin:0;">
<div id="wrapper">
	<div style="line-height:5rem;background-color: #3283FD;width: 100%;height: 5rem;vertical-align: middle;text-align: center;">
		<span style="vertical-align: middle;text-align: center;line-height: 5rem;">职位详情122</span>
	</div>
	<div id="scroller">
		<div style="padding-left: 1rem;padding-right: 1rem;padding-top: 1rem;padding-bottom: 4rem;margin-bottom: 1rem;">
			<div style="line-height:3rem;background-color: white;width: 100%;height: 3rem;vertical-align: middle;">
				<span style="vertical-align: middle;">${pid.position.position_name}</span>
			</div>
			<hr>
		<table style="width: 100%">
			<tr><td style="color: #F58023;">一线3年薪资18486元/月</td><td style="color: #F58023;font-size: 1.2rem">vs</td><td style="">二线3年薪资12486元/月</td><td style="color: #F58023;font-size: 1.2rem">vs</td><td style="">本地3年薪资10486元/月</td></tr>
			<tr  style="text-align: center;"><td colspan="2" style="text-align: right;">社会需求量480486个</td><td style="color: #F58023;font-size: 1.6rem">vs</td><td colspan="2" style="text-align: left;">本地需求量9486个</td></tr>
		</table>
		
		
		<hr style="height:0.8rem;border:none;border-top:0.8rem solid #F1F1F1;width: 100%">
		<div style="padding-right: 1rem;">
			<div style="display:table-cell;height:3rem;vertical-align:middle;text-align:center;">
				<span style="line-height:3rem;display: block;vertical-align:middle;"><img style="height: 3rem;vertical-align:middle;" src="<%=request.getContextPath()%>/image/line.png">&nbsp;职位简介</span>
			</div>
			<hr>
			<div style="padding-left: 1.2rem;">
				<span style="font-size: 1.6rem">职位内容</span><br/>
				<span style="font-size: 1.4rem;color: #666666;">${pid.introduce}</span>
			</div>
			<div style="padding-top: 0.8rem;padding-left: 1.2rem;">
				<span style="font-size: 1.6rem">职位要求</span><br/>
				<span style="font-size: 1.4rem;color: #666666;">${pid.requirement}</span>
			</div>
	   </div>
	   
	   
	   <hr style="height:0.8rem;border:none;border-top:0.8rem solid #F1F1F1;width: 100%">
	   <div style="padding-left: 1rem;padding-right: 1rem;">
			<table style="width: 100%;padding: 0rem;vertical-align: middle;border: none;">
				<tr>
					<th style="background-color: white;">地区</th>
					<th>需求量</th>
					<th>平均工资(元)</th>
				</tr>
				<c:forEach items="${pid.pmList}" var="pm" varStatus="index">
					<tr>
						<td style="text-align:certen;vertical-align: middle;background-color: white;padding: 0.2rem;" >
							<c:choose>  
								<c:when test="${index.count ==1}">
									<img style="height: 1.8rem;width: 1.8rem;vertical-align: top;" src="<%=request.getContextPath()%>/image/one.png">&nbsp;${pm.city_name}
								</c:when>
								<c:when test="${index.count ==2}">
									<img style="height: 1.8rem;width: 1.8rem;vertical-align: top;" src="<%=request.getContextPath()%>/image/two.png">&nbsp;${pm.city_name}
								</c:when>  
								<c:when test="${index.count ==3}">
									<img style="height: 1.8rem;width: 1.8rem;vertical-align: top;" src="<%=request.getContextPath()%>/image/three.png">&nbsp;${pm.city_name}
								</c:when>  
								<c:otherwise>
								${index.count}&nbsp;${pm.city_name}
								</c:otherwise>  
							</c:choose> 
						</td>
						<td>${pm.local_demand}</td>
						<td>
						<fmt:formatNumber var="temp" type="number" value="${pm.local_avg_salary}" maxFractionDigits="0"/> 
						${temp}
						</td>
					</tr>
				</c:forEach>
			
			</table>
		</div>
	</div>
</div>

<div style="float: left">
adafadfaf
</div>

<script type="text/javascript">
function IsPC() {
    var userAgentInfo = navigator.userAgent;
    var Agents = ["Android", "iPhone",
                "SymbianOS", "Windows Phone",
                "iPad", "iPod"];
    var flag = true;
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) {
            flag = false;
            break;
        }
    }
    return flag;
}
var isPc = IsPC();
if(isPc){
	document.getElementsByTagName('body')[0].style.width = '60%';
	document.getElementsByTagName('body')[0].style.margin = 'auto';
}

</script>
</body>
</html>