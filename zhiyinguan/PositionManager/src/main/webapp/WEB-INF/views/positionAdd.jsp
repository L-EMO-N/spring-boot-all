<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ page isELIgnored = "false"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="favicon.ico" >
    <link rel="Shortcut Icon" href="favicon.ico" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="<%=request.getContextPath()%>/lib/html5.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/h-ui.admin/css/common.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>添加用户 - H-ui.admin v3.0</title>
    <meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>



<section class="">
    <div class="Hui-article">
        <article class="cl pd-20">
            <form class="form form-horizontal" action="<%=request.getContextPath()%>/position/savePosition">
                <div class="mt-20">
                    <table class="table table-border  table-hover table-bg ">
                        <thead>
                        <tr class="text-c">

                            <th width="60"></th>
                            <th></th>
                            <th  colspan="3"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="text-c">
                            <td  class="text-r">
                                <i class="avatar size-XXL "><img alt="" src="<%=request.getContextPath()%>/static/h-ui/images/ucnter/avatar-default.jpg"></i></td>
                            <td class="text-l">
                                <h3>职位名称:<input type="text" class="input-com" id="position_name" name="position_name" value=""></h3>
                                <p >三年工作平均薪资（元/月)
                                    <!--&nbsp;&nbsp;&nbsp;&nbsp;-->
                                    <label class="c-999 f-12" style="padding-left: 20px">
                                        一线 <input type="text"  id="one_line_salary" name="one_line_salary" class="input-com" value="">
                                        vs  二线
                                        <input type="text"  class="input-com" id="two_line_salary" name="two_line_salary" value="">
                                    </label>
                                </p>
                                <!--<div class="c-999 f-12">
                                    一线 12313213132  vs  本地 43231 </div>-->
                                <p>需求量（人） <label class="c-999 f-12" style="padding-left: 60px">
                                    社会 <input type="text" name="total_demand" id="position_total_demand"  class="input-com" value="">
                                    <%--vs  本地 <input type="text"  class="input-com">--%>
                                </label></p>
                            </td>

                            <td class="td-manage" colspan="3" ></td>
                        </tr>
                        </tbody>
                    </table>
                    <%--positionMarket--%>
                    <div class="row cl">
                        <!--<label class="form-label col-xs-4 col-sm-3"></label>-->
                        <div><b>各地需求：</b> <span class="select-box-overried">
					<select class="select-overried" size="1" name="city_code" id="city_code" onchange="putValue(this)">
						<option value="">请选择</option>
						<option value="510">四川</option>
						<option value="252">重庆</option>
					</select>
					</span>
                            <span>需求量:<input type="text" class="input-com" name="local_demand" id="local_demand" value="">
                                            平均工资：<input type="text" class="input-com" name="local_avg_salary" id="local_avg_salary" value="">
                                <input type="hidden" name="city_name" id="city_name" value="">
                                <input type="hidden" name="pm_id" id="pm_id" value="">
                            </span>
                        </div>
                    </div>
                    <%--positionMarket--%>
                    <br/>
                    <%--<positionIntroduce--%>
                    <div class="row cl">
                        <label>名词解释：</label>
                        <div class="formControls">
                            <textarea name="noun_interpretation" id="noun_interpretation" cols="" rows="" class="textarea"  maxlength="1500" placeholder="名词解释"  onKeyUp="textarealength(this,1500)">
                            </textarea>
                            <p class="textarea-numberbar"><em class="textarea-length">0</em>/1500</p>
                        </div>
                    </div>

                    <div class="row cl">
                        <label>职位内容：</label>
                        <div class="formControls">
                            <textarea name="introduce" id="introduce" cols="" rows=""   maxlength="3000" class="textarea"  placeholder="职位内容" onKeyUp="textarealength(this,3000)">
                            </textarea>
                            <p class="textarea-numberbar"><em class="textarea-length">0</em>/3000</p>
                        </div>
                    </div>

                    <div class="row cl">
                        <label>职位要求：</label>
                        <div class="formControls">
                            <textarea name="requirement" id="requirement" cols="" rows="" class="textarea"   maxlength="500" placeholder="职位要求" onKeyUp="textarealength(this,500)">
                            </textarea>
                            <p class="textarea-numberbar"><em class="textarea-length">0</em>/500</p>
                        </div>
                    </div>
                    <div class="row cl">
                        <label>晋升空间：</label>
                        <div class="formControls">
                            <textarea name="direction"  id="direction" cols="" rows="" class="textarea"  maxlength="500" placeholder="晋升空间" onKeyUp="textarealength(this,500)">
                            </textarea>
                            <p class="textarea-numberbar"><em class="textarea-length">0</em>/500</p>
                        </div>
                    </div>
                 <div style="margin-left: 90%;margin-top: 20px"><button class="btn btn-primary radius" type="button"  onclick="formSubmit()" >提交</button></div>
                </div>
                <%--positionIntroduce--%>
            </form>
        </article>

    </div>
</section>


<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery_form.js"></script>
<script type="text/javascript">
    var index;
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#form-member-add").validate({
            rules:{
                username:{
                    required:true,
                    minlength:2,
                    maxlength:16
                },
                sex:{
                    required:true,
                },
                mobile:{
                    required:true,
                    isMobile:true,
                },
                email:{
                    required:true,
                    email:true,
                },
                uploadfile:{
                    required:true,
                },

            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                $(form).ajaxSubmit();
                var index = parent.layer.getFrameIndex(window.name);
                parent.$('.btn-refresh').click();
                parent.layer.close(index);
            }
        });

        /** 
         *数据读取出来会带有大量的空格  先去掉空格 然后计算字符
         * 会产生大量空格的原因 暂时没有找到
         * 此处采用百度或者其他的编辑器应该可以解决
        */
        $("#requirement").val($.trim($("#requirement").val()));
        $("#noun_interpretation").val($.trim($("#noun_interpretation").val()));
        $("#introduce").val($.trim($("#introduce").val()));
        $("#direction").val($.trim($("#direction").val()));
         index=parent.layer.getFrameIndex(window.name);
    });
    /**
     * 验证textarea输入框字数限制,只作提示不作提交限制
     * 参考：<em class="textarea-length">0</em>/<am>100</am>
     * @param obj
     * @constructor
     */
    var textarealength = function (obj,maxLength){
        var html = $(obj).parent();
//    var tatal = html.find('am').html();
        var sets = $(obj).val().length;

        if(sets*1>maxLength*1){
            var str = '<div style="width: auto;position: absolute; right: 4%;color: red;">内容超出限制</div>';
            $(obj).after(str);
            html.find('em').css({color:'red'});
        }else {
            html.find('em').css({color:'black'});
        }
        //设置已输入数量
        html.find('em').html(sets);
    }

    function putValue(obj){
    /*<span>需求量:<input type="text" class="input-com" id="positionMarket.total_demand">
            平均工资：<input type="text" class="input-com" id="positionMarket.avg_salary"></span>*/
        var city_name = $("#city_code option:selected").text();
        $("#city_name").val($.trim(city_name));
    }

    function formSubmit(){
        var reg =/^[1-9]\d*$/;
        var  reg1 = /^[0-9]+(.\d+)?$/;
        var position_name = $("#position_name").val();
        var one_line_salary = $("#one_line_salary").val();
        var two_line_salary = $("#two_line_salary").val();
        var position_total_demand =$("#position_total_demand").val();
        var local_demand = $("#local_demand").val();
        var local_avg_salary = $("#local_avg_salary").val();
        if(position_name == null || ($.trim(position_name))==''){
                layer_show("职位名称不能为空");
                return ;
        }
        if(position_total_demand != null && !reg.test(position_total_demand)){
            layer_show("需求量（人）只能是正整数");
            return ;
        }
        if(local_demand != null && !reg.test(local_demand)){
            layer_show("需求量只能是正整数");
            return ;
        }
        if(one_line_salary != null &&one_line_salary != '' && !reg1.test($.trim(one_line_salary))){
            layer_show("薪水（一线）填写错误");
            return;
        }
        if(two_line_salary != null && !reg1.test(two_line_salary)){
            layer_show("薪水（二线）填写错误");
            return;
        }
        if(local_avg_salary != null && !reg1.test(local_avg_salary)){
            layer_show("本地平均薪水 填写错误");
            return;
        }
        $("form").ajaxSubmit(function(data){
           layer_show(data.desc);
           setTimeout('layer_close()',1000);
        })
    }

    function layer_close(){
        parent.layer.close(index);
    }
    function layer_show(msg){
        layer.msg(msg, {
            offset: 't',
            anim: 6,
            time:2000
        });
    }
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>