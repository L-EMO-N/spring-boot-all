package com.lemon.weixin.type.controller;

import com.lemon.weixin.common.BaseResponse;
import com.lemon.weixin.common.Constans;
import com.lemon.weixin.resp.DataResp;
import com.lemon.weixin.type.entity.Type;
import com.lemon.weixin.type.service.ITypeService;
import com.lemon.weixin.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <p>Description: </p>
 * <p>Company:</p>
 * @author luolin
 * @date 2018/1/30
 */
@RestController
@RequestMapping(value = "/type")
public class TypeController {

    @Autowired
    private ITypeService typeService;

    /**
     *
     * @param type
     * @return
     */
    @RequestMapping("/saveType")
    public BaseResponse saveType(Type type){
        BaseResponse resp = new BaseResponse();
        try {
            if(StringUtils.isBlank(type.getName())){
                    resp.setCode(Constans.ERROR_CODE1);
                    resp.setDesc("类别名不能为空");
                    return resp;
            }
            String dateStr = DateUtil.getTimeStr(new Date());
            type.setCreateTime(dateStr);
            type.setModifyTime(dateStr);
            int count =typeService.insertType(type);
            if(count > 0){
                resp.setCode(Constans.SUCCESS_CODE);
                resp.setDesc(Constans.SUCCESS_DESC);
                return  resp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }


      /**
       *@Description:根据id获取type
       *@author luolin
       *@date 2018/2/2
      */
    @RequestMapping("/getTypeById")
    public DataResp<Type> getTypeById(long id){
        DataResp<Type> resp = new DataResp<>();
        Type type = null;
        try {
            type = typeService.getTypeById(id);
            resp.setCode(Constans.SUCCESS_CODE);
            resp.setDesc(Constans.SUCCESS_DESC);
            resp.setData(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  resp;
    }

    @RequestMapping("/updateType")
    public BaseResponse updateType(Type type){
            BaseResponse resp = new BaseResponse();
        try {
            if(StringUtils.isBlank(type.getName())){
                    resp.setDesc("类别名称不能为空");
                resp.setCode(Constans.ERROR_CODE1);
                    return  resp;
            }
            //判断是否有重复的类别名
            int count = typeService.getCountByName(type.getName());
            if(count > 0){
                resp.setDesc("此名已经存在");
                resp.setCode(Constans.SUCCESS_CODE);
                return  resp;
            }
            int updateCount =  typeService.updateType(type);
            if(updateCount > 0){
                resp.setCode(Constans.SUCCESS_CODE);
                resp.setDesc(Constans.SUCCESS_DESC);
            }
        } catch (Exception e) {

        }
        return  resp;
    }

    @RequestMapping("/getCountByName")
    public int getCountByName(String name){
            int count = typeService.getCountByName(name);
            return  count;
    }


    /** 
     *@Description:  根据条件分页查询
     *@author luolin
     *@date 2018/2/2
    */
    @RequestMapping(value = "/getTypeList")
    public DataResp<List<Type>> getTypeList(Type type ,
                                            @RequestParam(value = "pageNumber",required = false) Integer pageNumber,
                                            @RequestParam(value = "pageSize",required = false) Integer pageSize){
            DataResp<List<Type>> resp = new DataResp<>();
            List<Type> list = new ArrayList<>();
        try {
            if(pageNumber > 0 && pageSize > 0){
                pageSize = (pageNumber - 1)*pageSize;
                pageNumber = 1;
            }else{
                pageNumber = 0;
                pageSize = -1;
            }
            list =typeService.getTypePage(type,pageSize,pageNumber);
            resp.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  resp;
    }


    @RequestMapping(value = "/testType")
    public Type testType(long id,String name){
       Type type =  typeService.getTypeByNameAndId(id,name);
       return type;
    }

    @RequestMapping("/deleteById")
    public BaseResponse deleteById(long id){
        BaseResponse resp = new BaseResponse();
        try {
            int count = typeService.deleteTypeById(id);
            if(count > 0){
                resp.setDesc(Constans.SUCCESS_DESC);
                resp.setCode(Constans.SUCCESS_CODE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

}
