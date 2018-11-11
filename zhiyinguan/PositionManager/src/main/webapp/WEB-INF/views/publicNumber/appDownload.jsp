<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no"/>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css?v=1.0.2" />

<style type="text/css">
* {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

body {font-size:1.8rem;}
hr{height:0.1rem;border:none;background-color: #F1F1F1}
</style>
<title>APP下载</title>
</head>

<body  style="margin:0;">
	<img src="../image/appdowm.png" style="width: 100%">
	<br/>
	<br/>
	<br/>
	<br/>
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