package com.lemon.weixin.context.service;

import com.lemon.weixin.context.entity.Answer;
import com.lemon.weixin.context.entity.Context;

import java.util.List;

/**
 * Created by luolin on 2018/1/29.
 */
public interface IContextService {

    //根据id获取实体
    public Context getContextById(Long id);

    //保存
    public int saveContext(Context context,Answer answer);

//    更新context
    public int updateContext(Context context, Answer answer);

//    根据条件分页查询context
    public List<Context> getContextPageByKey(Context context ,int start,int end);

//    根据id删除context
    public int deleteContextById(long id);

    Long getCountByKey(Context context);
}
