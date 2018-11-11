package com.lemon.weixin.context.service.impl;

import com.lemon.weixin.context.dao.AnswerDao;
import com.lemon.weixin.context.entity.Answer;
import com.lemon.weixin.context.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/2/6
 */
@Service("answerService")
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    private AnswerDao answerDao;

    @Override
    public Answer getAnswerByContextId(Long contextId) {
        return answerDao.getAnswerByContextId(contextId);
    }

    @Override
    public int deleteAnswerByContextId(long contextId) {
        return answerDao.deleteAnswerByContextId(contextId);
    }

    @Override
    public int saveOrUpdateAnswer(Answer answer) {
        return answerDao.saveOrUpdateAnswer(answer);
    }
}
