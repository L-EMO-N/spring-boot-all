package com.lemon.weixin.context.service;

import com.lemon.weixin.context.entity.Answer;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/2/6
 */
public interface IAnswerService {

    /** 
     *@Description: 根据contextId获取answer
     *@author luolin
     *@date 2018/2/6
    */
    public Answer getAnswerByContextId(Long contextId);

    /** 
     *@Description:  根据contextid删除
     *@author luolin
     *@date 2018/2/6
    */
    public  int deleteAnswerByContextId(long contextId);

    /** 
     *@Description:  添加或更新操作
     *@author luolin
     *@date 2018/2/6
    */
    public int saveOrUpdateAnswer(Answer answer);
}
