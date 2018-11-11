package com.lemon.weixin.context.controller;

import com.lemon.weixin.common.BaseResponse;
import com.lemon.weixin.common.Constans;
import com.lemon.weixin.context.entity.Answer;
import com.lemon.weixin.context.entity.Context;
import com.lemon.weixin.context.service.IAnswerService;
import com.lemon.weixin.context.service.IContextService;
import com.lemon.weixin.resp.DataResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 */

@RestController
@RequestMapping("context")
public class ContextController {

    @Autowired
    private IContextService contextService;

    @Autowired
    private IAnswerService answerService;

    @RequestMapping("/getContextById")
    public Context getContextById(Long id){
        return contextService.getContextById(id);
    }

    public ContextController() {
        super();
    }

    /**
     *@Description:  添加context
     *@author luolin
     *@date 2018/2/9
    */
    @RequestMapping(value = "/saveContext")
    public BaseResponse saveContext(Context context, Answer answer){
        BaseResponse resp = new BaseResponse();
        try {
            if(StringUtils.isBlank(context.getTitle())){
                    resp.setCode(Constans.ERROR_CODE1);
                    resp.setDesc("标题不能为空");
                    return resp;
            }
//            context.setCreateTime();
            long contextId = contextService.saveContext(context,answer);
            resp.setCode(Constans.SUCCESS_CODE);
            resp.setDesc(Constans.SUCCESS_DESC);
            return resp;
        } catch (Exception e) {
          resp.setCode(Constans.ERROR_CODE1);
          resp.setDesc("保存context失败");
          return  resp;
        }
    }

    /** 
     *@Description:  删除context
     *@author luolin
     *@date 2018/2/9
    */
    @RequestMapping(value = "/deleteContextById")
    public BaseResponse deleteContextById(long id){
        BaseResponse resp = new BaseResponse();
        try {
            int count = contextService.deleteContextById(id);
            //与context关联的answer也删除
            if(count > 0){
                answerService.deleteAnswerByContextId(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    /** 
     *@Description: 更新updateContext
     *@author luolin
    */
    @RequestMapping("/updateContext")
    @Transactional
    public BaseResponse updateContext(Context context, Answer answer){
        BaseResponse resp = new BaseResponse();
        try {
            if(StringUtils.isBlank(context.getTitle())){
                    resp.setCode(Constans.ERROR_CODE1);
                    resp.setDesc("内容不能为空");
                    return resp;
            }
            if(context.getId() == null){
                resp.setCode(Constans.ERROR_CODE1);
                resp.setDesc("要修改的数据不存在");
                return resp;
            }
            contextService.updateContext(context,answer);
            resp.setCode(Constans.SUCCESS_CODE);
            resp.setDesc("更新成功");
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            resp.setCode(Constans.ERROR_CODE1);
            resp.setDesc(" 更新内容失败");
            return resp;
        }
    }

    /**
     *@author luolin
    */
    @RequestMapping("/getContextList")
    public DataResp<List<Context>> getContextList(Context context,String title){
        DataResp<List<Context>> resp = new DataResp<>();
        try {
            if(context.getPageNumber() <= 0 && context.getPageSize() <=0){
                resp.setCode(Constans.ERROR_CODE1);
                resp.setDesc("页码不能为空");
                return resp;
            }

            int start = (context.getPageNumber() - 1) * context.getPageSize();
            int end = context.getPageSize();
            List<Context> list = contextService.getContextPageByKey(context, start, end);
            if(list != null && list.size() > 0){
                Long count = contextService.getCountByKey(context);
                resp.setAllTotal(count);
            }
            resp.setData(list);
            resp.setCode(Constans.SUCCESS_CODE);
            resp.setDesc("请求成功");
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            resp.setCode(Constans.ERROR_CODE1);
            resp.setDesc("请求失败");
            return  resp;
        }
    }

}
