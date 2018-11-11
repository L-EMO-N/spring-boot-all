package com.lemon.weixin.context.dao;

import com.lemon.weixin.context.entity.Answer;
import org.apache.ibatis.annotations.*;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/2/6
 */
public interface AnswerDao {

    /**
     *@Description: 根据contextId获取answer
     *@author luolin
     *@date 2018/2/6
     */
    @Select("select * from answer where context_id =#{contextId}")
    @Results(
            @Result(column = "context_id",property = "contextId")
    )
    public Answer getAnswerByContextId(Long contextId);

    /**
     *@Description:  根据contextid删除
     *@author luolin
     *@date 2018/2/6
     */
    @Delete("delete from answer where context_id=#{contextId}")
    public  int deleteAnswerByContextId(long contextId);

    /**
     *@Description:  添加或更新操作
     *@author luolin
     *@date 2018/2/6
     */
    @Insert(" replace into answer values(#{id},#{contextId},#{answerA},#{scoreA}" +
            ",#{answerB},#{scoreB},#{answerC},#{scoreC},#{answerD},#{scoreD})")
    public int saveOrUpdateAnswer(Answer answer);
}
