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
<title>意见反馈</title>
<style type="text/css">
	* {
		-webkit-box-sizing: border-box;
		-moz-box-sizing: border-box;
		box-sizing: border-box;
	}
	body {font-size:1.6rem;}
	hr{height:0.1rem;border:none;background-color: #F1F1F1}
</style>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js?v=1.0.0"></script>
</head>
<body style="margin:0;background-color: #F1F1F1;">          
	<div style="line-height:5rem;background-color: #3283FD;width: 100%;height: 5rem;vertical-align: middle;text-align: center;">
		<span style="vertical-align: middle;text-align: left;line-height: 5rem;font-size:1.8rem;">意见反馈</span>
	</div>
	
	<textarea id="opinionsOrSuggestions" rows="10" cols="" style="width: 100%;font-size: 1.6rem;border: none;color:#808080;" ></textarea>
	
	<hr/>
	<hr/>
	<div style="line-height:5rem;background-color: #ffffff;width: 100%;height: 5rem;vertical-align: middle;">
		&nbsp;&nbsp;联系方式:
		<input id="contactInformation" type="text" value="" style="font-size:1.5rem;padding: 0.5rem;width: 70%;color:#808080;border: none;">
	</div>
	
	<div style="line-height:5rem;width: 100%;height: 5rem;vertical-align: middle;text-align: center;margin-top: 5rem;z-index: 9;">
	<button style="font-size:1.6rem;padding: 0.5rem;width: 75%;height:4rem;vertical-align: middle;text-align: center;background-color: #3283FD;color: #ffffff;border-radius: 1rem;border: none;" onclick="submit()">提交</button>
	</div>
	
	
	<script type="text/javascript">

		var str="请输入意见或建议";
		var opinionsOrSuggestions = $("#opinionsOrSuggestions");
		opinionsOrSuggestions.val(str);
		opinionsOrSuggestions.focus(function(){
		   var v=this.value;
		   if(v == str){
		        $(this).val("");
		    }
		}).blur(function(){
		    var v=this.value;
		    if(v == ""){
		        $(this).val(str);
		    }
		});
		
		var str2 = "微信/QQ/手机号,以便我们联系你";
		var contactInformation = $("#contactInformation");
		contactInformation.val(str2);
		contactInformation.focus(function(){
		   var v=this.value;
		   if(v == str2){
		        $(this).val("");
		    }
		}).blur(function(){
		    var v=this.value;
		    if(v == ""){
		        $(this).val(str2);
		    }
		});
		
		function submit(){
			var opinionsOrSuggestions = document.getElementById("opinionsOrSuggestions").value;
			var contactInformation = document.getElementById("contactInformation").value;
			
			if(opinionsOrSuggestions==null || opinionsOrSuggestions.trim() == "" || opinionsOrSuggestions == str){
				alert("请输入你的意见或建议.");
				return;
			}
			
			var data = "{\"content\":\""+opinionsOrSuggestions+"\",\"qq\":\""+contactInformation+"\"}";
			var url = '../system/saveFeedback';
			$.ajax({
		        type: "post",
		        url: url,
		        dataType:'JSON',
		        data: data,
		        contentType: 'application/json;charset=utf-8',
		        success: function (data) {
		            if (data != "") {
		            	 var json = eval(data); //数组   
		            	 if(json.code==200){
		            		 alert("感谢你的建议和意见!我们会及时处理.");
		            	 }else{
		            		 alert(json.message);
		            	 }
		            }
		        },
		        error: function(data) {
		        	 alert("提交失败");
		        }
		    });
		}
</script>

</body>
</html>