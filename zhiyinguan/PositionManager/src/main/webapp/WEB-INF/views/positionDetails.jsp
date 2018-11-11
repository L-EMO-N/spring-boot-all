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
    width: 45%;
}
#center
{
    background: #ffffff;
    float: left;
    width: 10%;
}
#right
{
    background: #ffffff;
    float: right;
    width: 45%;
}

td
{
	width:33.33%;
	vertical-align: middle;
	text-align: center;
	font-size: 1.4rem;
	background-color: #ffffff;
	padding: 0.8rem;
	color: #999999;
	
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
<title>职位分享</title>
</head>
<body style="margin:0;">
<div id="wrapper">
	<div style="line-height:5rem;background-color: #3283FD;width: 100%;height: 5rem;vertical-align: middle;text-align: center;">
		<span style="vertical-align: middle;text-align: center;line-height: 5rem;">职位详情</span>
	</div>
	<div id="scroller">
		<div style="padding-left: 1rem;padding-right: 1rem;padding-top: 1rem;padding-bottom: 4rem;margin-bottom: 1rem;">
			<div style="line-height:3rem;background-color: white;width: 100%;height: 3rem;vertical-align: middle;">
				<span style="vertical-align: middle;">${pid.position.position_name}</span>
			</div>
			<div id="wrap" style="height: 4rem;vertical-align: middle;text-align: center;">
				<div style="text-align: center;height: 4rem;">
					<span style="color: #F58023;font-size: 2rem">
					<b>
					${pid.position.show_local_avg_salary}
					</b>
					</span>
					<br>
					<span style="color: #999999;font-size: 1.6rem">${pid.position.city_name}3年平均薪资</span>
				</div>
			</div>
			<div id="wrap" style="vertical-align: middle;text-align: center;padding-top: 1.5rem">
				<div id="left" style="text-align: center;padding-top: 0.75rem;padding-bottom: 0.75rem;">
					<span style="color: #999999;font-size: 1.2rem">一线3年薪资:${pid.position.show_one_line_salary}</span>
				</div>
				<div id="center" >
					<span style="color: #F58023;font-size: 1.6rem">vs</span>
				</div>
				<div id="right" style="text-align: center;padding-top: 0.75rem;padding-bottom: 0.75rem;">
					<span style="color: #999999;font-size: 1.2rem">二线3年薪资:${pid.position.show_two_line_salary}</span>
				</div>
			</div>
			<hr>
			<div id="wrap" style="vertical-align: middle;text-align: center;">
				<div id="left" style="text-align: center;;padding-top: 0.75rem;padding-bottom: 0.75rem;">
					<span style="color: #999999;font-size: 1.2rem">社会需求量:${pid.position.show_total_demand}</span>
				</div>
				<div id="center">
					<span style="color: #F58023;font-size: 1.6rem">vs</span>
				</div>
				<div id="right" style="text-align: center;padding-top: 0.75rem;padding-bottom: 0.75rem;">
					<span style="color: #999999;font-size: 1.2rem">本地需求量:${pid.position.show_local_demand}</span>
				</div>
			</div>
		</div>
		
		
		<hr style="height:0.8rem;border:none;border-top:0.8rem solid #F1F1F1;width: 100%">
		<div style="padding-right: 1rem;">
			<div style="display:table-cell;height:3rem;vertical-align:middle;text-align:center;">
				<span style="line-height:3rem;display: block;vertical-align:middle;"><img style="height: 3rem;vertical-align:middle;" src="<%=request.getContextPath()%>/image/line.png">&nbsp;职位简介</span>
			</div>
			<hr>
			<div style="padding-left: 1.2rem;">
				<span style="font-size: 1.6rem">名词解释</span><br/>
				<span style="font-size: 1.4rem;color: #666666;">${pid.noun_interpretation}</span>
			</div>
			<div style="padding-top: 0.8rem;padding-left: 1.2rem;">
				<span style="font-size: 1.6rem">职位内容</span><br/>
				<span style="font-size: 1.4rem;color: #666666;">${pid.introduce}</span>
			</div>
			<div style="padding-top: 0.8rem;padding-left: 1.2rem;">
				<span style="font-size: 1.6rem">职位要求</span><br/>
				<span style="font-size: 1.4rem;color: #666666;">${pid.requirement}</span>
			</div>
			
			<div style="padding-top: 0.8rem;padding-left: 1.2rem;">
				<span style="font-size: 1.6rem">晋升空间</span><br/>
				<span style="font-size: 1.4rem;color: #666666;">${pid.direction}</span>
			</div>
			
			<div style="padding-top: 0.8rem;padding-left: 1.2rem;">
				<span style="font-size: 1.6rem">就业前景</span><br/>
				<span style="font-size: 1.4rem;color: #666666;">${pid.prospects}</span>
			</div>
			
	   </div>
	   
	   
	   <hr style="height:0.8rem;border:none;border-top:0.8rem solid #F1F1F1;width: 100%">
	   <div style="padding-left: 1rem;padding-right: 1rem;">
			<table style="width: 100%;padding: 0rem;vertical-align: middle;border: none;">
				<tr>
					<th style="background-color: white;">地区</th>
					<th>需求量(个)</th>
					<th>平均工资(元/月)</th>
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
						<td>${pm.show_local_demand}</td>
						<td>
							${pm.show_local_avg_salary}
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<br/><br/><br/>
</div>

<div id="downDive" style="display:none;float: left;position:fixed;bottom:0;background-color: #2b2b2b;opacity:0.7;width: 100%;height:5rem;text-align: center;vertical-align: middle;" onclick="downApp()">
	<span style="line-height:5rem;color:white;">点击下载APP</span>
</div>

<script type="text/javascript">
	var userAgentInfo = navigator.userAgent;
	function IsPC() {
	    var Agents = ["Android", "iPhone","Adr","SymbianOS", "Windows Phone","iPad", "iPod"];
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
	
	//alert(isPc);
	
	if(isPc){
		document.getElementsByTagName('body')[0].style.width = '60%';
		document.getElementsByTagName('body')[0].style.margin = 'auto';
		//document.getElementById('downDive').style.display = 'none';
	}else{
		document.getElementById("downDive").style.display = 'block';
	}
	
	
	//js判断是否是苹果设备
	function checkIsAppleDevice() {
		var u = navigator.userAgent;
	         var ios = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/);
	         var iPad = u.indexOf('iPad') > -1;
	         var iPhone = u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1;
	         if (ios || iPad || iPhone) {
	             return true;
	         } else {
	             return false;
	         }
	     }


	//js判断是否为Android设备
	function checkIsAndroidDevice(){
		var u = navigator.userAgent;
		if ( u.indexOf('Android') > -1 || u,indexOf('Adr') > -1 ){
			return true;
		}else{
			return false;
		}
	}

	
	function downApp(){
		if (checkIsAppleDevice()) {
			//alert("ios");
			window.location.href = "https://itunes.apple.com/us/app/998dian-wan-cheng/id1135278767?mt=8";//跳转到AppStore或者Android应用市场
	    } else {
	    	//alert("android");
			window.location.href = "http://zhiyinguan-img.oss-cn-shenzhen.aliyuncs.com/update/zhiyinguan.apk";//打开apk
	    }
	}
	

</script>
</body>
</html>