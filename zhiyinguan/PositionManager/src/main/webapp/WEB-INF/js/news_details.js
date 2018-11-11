	function get(ts){
		//alert("onload");
		ts.style.display = 'block';  //显示图片
//		ts.height=200;
		//alert(ts.readyState);
	}
	
	function error(ts){
		//ts.height=1;
		alert("err");
	}
	document.addEventListener('DOMContentLoaded', function () { setTimeout(loaded, 0); }, false);
	
	function loaded(){
		callAndroid();
		callIos();
	}
	function callAndroid(){
//		if(window.android!=null&&typeof(window.android)!="undefined"){
//	        window.android.loadCompletion();
//      	}else{
//	        alert(typeof(window.android));
//        }
	}
	function callIos(){
		
	}
	
	function is_collect(){
		var is_collect = document.getElementById("is_collect").value;
		window.app.is_collect(is_collect);
	}
	