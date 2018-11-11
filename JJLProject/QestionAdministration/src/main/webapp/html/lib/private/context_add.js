


var path = 'http://localhost:8080/jjl';

var pic_path ='http://118.24.16.215:9999/';

var update_flag ;


$(function(){
    var url=location.search;

    update_flag = url;
    if(update_flag){
        var id = url.split('=')[1];
        // console.log(id);
        $("#context_id").val(id);
        $.ajax({
            url:'/jjl/context/getContextById',
            type:'post',
            data:{id:id},
            success:function(data){
                // console.log(data);
                if(data){
                    var answer = data.answer;
                    $("#title").val(data.title);
                    $("#answerA").val(answer.answerA);
                    $("#answerB").val(answer.answerB);
                    $("#answerC").val(answer.answerC);
                    $("#answerD").val(answer.answerD);
                    if(data.picUrl){
                        var src = pic_path+data.picUrl;
                        $("#show_pic").attr("src",src);
                        $("#picUrl").val(data.picUrl);
                    }
                }
            }
        })
    }else{
        $("#context_id").remove();
    }

})
/*$(document).ready(function(){
});*/

//图片上传
function clickFile(){
    $("#file").click();
}

function uploadFile(){
    var old_pic = $("#show_pic").attr("src");
    $("#oldPic").val(old_pic);
    var formData = new FormData($('#upload_file')[0]);
    $.ajax({
            type:'post',
            url:path+"/file/uploadFile",
            data: formData,
            cache: false,
            processData: false,
            contentType: false,
            success:function(data){
                // console.log(data);
                if(data.data){
                    var src = pic_path+data.data;
                    $("#show_pic").attr("src",src);
                    $("#picUrl").val(data.data);
                }

            }
    });
}

function  closeLayer() {
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    // console.log(index);
    parent.layer.close(index); //再执行关闭
}

function submitForm(){

    var tilte = $("#title").val();
    var answerA = $("#answerA").val();
    var answerB = $("#answerB").val();
    var answerC = $("#answerC").val();
    var answerD= $("#answerD").val();
    if(tilte == null || tilte == "" ||$.trim(tilte) == null){
            layer.alert("题干不能为空",{
                time:1500
            });
            return ;
    }

    if((answerA == null || answerA == "" || $.trim(answerA) == null) && (answerB == null || answerB == "" || $.trim(answerB) == null) &&
        (answerC == null ||  answerC == ""|| $.trim(answerC) == null)&& (answerD == null ||  answerD == "" || $.trim(answerD) == null)){

        layer.alert("答案不能为空",{
            time:1500
        })
        return ;
    }

    var url ;
    if(update_flag){
        url = '/jjl/context/updateContext';
    }else{
        url = '/jjl/context/saveContext';
    }

   $.ajax({
       url:url,
       type:'post',
       data:$("#form-article-add").serialize(),
       success:function (data) {
           // console.log(data);
           layer.msg(data.desc, {
               icon: 1,
               time: 1500 //1.5秒关闭（如果不配置，默认是3秒）
           }, function(){
               closeLayer();
           });
       }
   })
}