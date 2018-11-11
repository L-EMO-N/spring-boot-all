var myScroll,pullDownEl, pullDownOffset,pullUpEl, pullUpOffset,generatedCount = 0;
var groupId;
var curPage=1;
var pageSize=20;


var screenHeight = window.screen.height;

var imgHeight = screenHeight/7;

//屏幕分辨率的高：window.screen.height 
//屏幕分辨率的宽：window.screen.width 
//屏幕可用工作区高度：window.screen.availHeight 
//屏幕可用工作区宽度：window.screen.availWidth 

function loaded() {
	//动画部分
	pullDownEl = document.getElementById('pullDown');
	pullDownOffset = pullDownEl.offsetHeight;
	pullUpEl = document.getElementById('pullUp');	
	pullUpOffset = pullUpEl.offsetHeight;
	myScroll = new iScroll('wrapper', {
		useTransition: true,
		topOffset: pullDownOffset,
		checkDOMChanges:true,
		vScrollbar:true,
		onRefresh: function () {
			if (pullDownEl.className.match('loading')) {
				pullDownEl.className = '';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉推荐';
			} else if (pullUpEl.className.match('loading')) {
				pullUpEl.className = '';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多';
			}
		},
		onScrollMove: function () {
		
		 if (this.y > 5 && !pullDownEl.className.match('flip')) { 
            pullDownEl.className = 'flip'; 
            pullDownEl.querySelector('.pullDownLabel').innerHTML = '松手开始加载'; 
            this.minScrollY = 0; 
        } else if (this.y < 5 && pullDownEl.className.match('flip')) { 
            pullDownEl.className = ''; 
            pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉推荐'; 
            this.minScrollY = -pullDownOffset; 
        } else if (this.y < (this.maxScrollY - 5) && !pullUpEl.className.match('flip')) { 
            pullUpEl.className = 'flip'; 
            pullUpEl.querySelector('.pullUpLabel').innerHTML = '松手开始加载'; 
            this.maxScrollY = this.maxScrollY; 
        } else if (this.y > (this.maxScrollY + 5) && pullUpEl.className.match('flip')) { 
            pullUpEl.className = ''; 
            pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多'; 
            this.maxScrollY = pullUpOffset; 
        } 

		},
		onScrollEnd: function () {
			if (pullDownEl.className.match('flip')) {
				pullDownEl.className = 'loading';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '加载中...';	
				pullDownAction();	// Execute custom function (ajax call?)
				
			} else if (pullUpEl.className.match('flip')) {
				pullUpEl.className = 'loading';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = '加载中...';				
				pullUpAction();	// Execute custom function (ajax call?)
			}
		}
	});
	
	loadAction();
}
function reset(){
	pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉推荐';	
	pullDownEl.className='';
	pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多'; 
	pullUpEl.className='';
}

function noData(){
	pullDownEl.className='';
	pullUpEl.className='';
	
	pullDownEl.querySelector('.pullDownLabel').innerHTML = '暂无更多数据';	
	pullUpEl.querySelector('.pullUpLabel').innerHTML = '暂无更多数据'; 
	
	setTimeout(function () {
		pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉推荐';	
		pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多'; 
	}, 6000);
	
}

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);//阻止冒泡
document.addEventListener('DOMContentLoaded', function () { setTimeout(loaded, 0); }, false);

//初始状态，加载数据
function loadAction(groupId){
	requestData(1);
}

//下拉刷新当前数据
function pullDownAction () {
	setTimeout(function () {
		//这里执行刷新操作
//		alert("下拉刷新");
		requestData(0);
	}, 400);
}

//上拉加载更多数据
function pullUpAction () {
	setTimeout(function () {
//		alert("上拉加载更多");
		requestData(1);
	}, 400);
}

function requestData(upOrDwon){
	  var data = '';
	  if(typeof positionId!="undefined"){
	  	data = '{"curPage":' + curPage + ',"pageSize":' + pageSize + ',"position_id":'+positionId+'}';
	  }else{
	  	data = '{"curPage":' + curPage + ',"pageSize":' + pageSize +'}';
	  }
	  var el = document.getElementById('thelist');
	  $.ajax({
	        type: "post",
	        url: url,
	        dataType:'JSON',
	        data: data,
	        contentType: 'application/json;charset=utf-8',
	        success: function (data) {
	            if (data != "") {
	            	curPage++;
	            	 var json = eval(data); //数组   
	            	 data="";
	            	 if(json.code==200){
	            		 var list = json.data.list
	            		 if(list.length == 0){
	            			 noData();
		         	         myScroll.refresh();
	            		 }else{
	            			 var i=0;
	         	           $.each(list, function (index) {
		            			 
		                         //循环获取数据    
		                         var news_id = ""+list[index].news_id_str;
		                         var title = list[index].title;
		                         var image_urls = list[index].image_urls;
		                         var author = list[index].author;
		                         var time = list[index].publishTimeStr;
		                         var imageArray = list[index].imageArray;
		                         var commentCount = list[index].comment_count;
//		                         console.info(news_id);
		                         var html="";
		                         if(imageArray!=null){
		                        	
			                         if(imageArray.length>=2){
			                        	 var html = "<a target='_blank' onclick='toNewsDetails(this,\""+news_id+"\");' class='font1' style=''>"
				                        	 				 +"<table style='width: 100%'>" 
				                        	 					+"<tr><td colspan='3' class=''>"+title+"</td></tr>"
				                        	 					+"<tr style='width: 100%' >";
				                         $.each(imageArray, function (imgIndex) {
				                        	 html += "<td style='width: 33.3%;'><img style='width: 100%;height:"+imgHeight+"' alt='${news.title}' src='"+imageArray[imgIndex]+"' onerror='error(this)' onload='load(this)' style='display:none'/></td>"
				                         });
				                         html += "<tr><td colspan='3'><font class='font2'>"+author+"</font>&nbsp;&nbsp;&nbsp;&nbsp;<font class='font2'>" + commentCount + "评论</font>&nbsp;&nbsp;&nbsp;&nbsp;<font class='font2'>"+time+"</font></td>" +
				                         		"</tr></table></a><HR class='hr1'/>"
			                         }else if(imageArray.length == 1){
			                        	 html = "<a target='_blank' onclick='toNewsDetails(this,\""+news_id+"\");' class='font1' style=''>"
			                        	 				+"<table style='width: 100%'>"
			                        	 					+"<tr><td colspan='2' style='text-align:left;vertical-align:top;'>"+title+"</td>"
			                        	 					+"<td style='width: 34%;'><img style='width: 100%;height: "+imgHeight+"' alt='${news.title}' src='"+imageArray[0]+"' onerror='error(this)' onload='load(this)' style='display:none' /></td></tr>"
			                        	 					+"<tr><td colspan='3'><font class='font2'>" + author + "</font>&nbsp;&nbsp;&nbsp;&nbsp;<font class='font2'>" + commentCount + "评论</font>&nbsp;&nbsp;&nbsp;&nbsp;<font class='font2'>" + time + "</font></td>"
			                        	 					+"</tr></table></a><HR class='hr1'/>"
			                         }
			                         
		                         }else{
		                        	 html = "<a target='_blank' onclick='toNewsDetails(this,\""+news_id+"\");' class='font1' style=''>"
                 	 				+"<table style='width: 100%'>"
                 	 					+"<tr><td colspan='3'><font style='text-align:left;vertical-align:top;'>"+title+"</font></td></tr>"
                 	 					+"<tr><td colspan='3'><font class='font2'>" + author + "</font>&nbsp;&nbsp;&nbsp;&nbsp;<font class='font2'>" + commentCount + "评论</font>&nbsp;&nbsp;&nbsp;&nbsp;<font class='font2'>" + time + "</font></td>"
                 	 					+"</tr></table></a><HR class='hr1'/>"
		                         }
		                         
		                         li = document.createElement('li');
		                         li.innerHTML = html;
		                         
		                         if(upOrDwon==1){
		                        	 el.appendChild(li, el.childNodes[0]);
		                         }else{
		                        	 el.insertBefore(li, el.childNodes[i]);
		                         }
		                         i++;
		                     }); 
	         	            reset();
	         	            myScroll.refresh();
	            		 }
	            		 
	            	 }else{
	            		 reset();
         	             myScroll.refresh();
	            	 }
	            }else{
	            	reset();
    	            myScroll.refresh();
	            }
	            
	        },
	        error: function(data) {
	        	reset();
	        	myScroll.refresh();
	        }
	   
	    });
	}

function toNewsDetails(a,newsId){
	a.style.color='#808080';
	if(typeof positionId!="undefined"){
		window.location.href="../getNewsDetails/"+newsId; 
	}else{
		window.location.href="getNewsDetails/"+newsId; 
	}
}

function load(ts){
	ts.style.display = 'block';  //显示图片
}

function error(ts){
	style='display:none'
}

