



$(function () {
    $('.M-box3').pagination({
        pageCount: 50,
        jump: true,
        coping: true,
        homePage: '首页',
        endPage: '末页',
        prevContent: '上页',
        nextContent: '下页',
        callback: function (api) {
            console.log(api.getCurrent())
        }
    });

     fetch("/jjl/context/getContextList",{
            method:'post',
            body:{title:'rwrwerw'}
         }
     ).then(function(data){
         return data.json();
     }).then(function(data){
         var context = data.data;
         if(context){
             console.log(context);
             var tr_td = "";
             for(var i = 0; i<context.length; i++){
                 var value = context[i];
                 var tr = '<tr class="text-c">';
                 var td = '<td>'+(i+1)+'</td>';
                        td = td+'<td> <i class="avatar size-XXL "><img alt="" src="static/h-ui/images/ucnter/avatar-default.jpg"></i></td>';
                        td = td+'<td>'+value.title+'</td>'
                        td = td +'<td class="td-manage">' +
                            '<a title="编辑" href="javascript:;" onclick="member_edit('+"'"+"编辑"+"',"+value.id+',0)" style="text-decoration:none">' +
                 '<i class="Hui-iconfont">&#xe6df;</i></a> ' +
                 '<a title="删除" href="javascript:;" onclick="member_del(this,'+"'"+value.id+"'"+')" class="ml-5" style="text-decoration:none">' +
                 '<i class="Hui-iconfont">&#xe6e2;</i></a></td>';
                  tr_td = tr_td + tr + td +'</tr>'
             };
             $("#context_table thead").append(tr_td);
         }else{
             $("#context_table thead").append('<tr><td colspan="4"  class="text-c">查询数据为空</td></tr>');
         }

     }).catch(function(err){
          console.log(err);
         $("#context_table thead").append('<tr><td colspan="4" class="text-c">查询异常</td></tr>');
     })
})