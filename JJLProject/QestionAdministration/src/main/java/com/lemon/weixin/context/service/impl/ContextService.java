package com.lemon.weixin.context.service.impl;

import com.lemon.weixin.context.dao.AnswerDao;
import com.lemon.weixin.context.dao.contextDao;
import com.lemon.weixin.context.entity.Answer;
import com.lemon.weixin.context.entity.Context;
import com.lemon.weixin.context.service.IContextService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 */
@Service
@Transactional
public class ContextService implements IContextService {

    @Autowired
    private contextDao contextDao;

    @Autowired
    private AnswerDao answerDao;

    @Override
    public Context getContextById(Long id) {
        return contextDao.getContextById(id);
    }

    @Override
    public int saveContext(Context context,Answer answer) {
        try {
//            int count  = 0;
            int count =  contextDao.saveContext(context);
            long contextId = context.getId();
            if(count > 0){
                answer.setContextId(contextId);
                 count = answerDao.saveOrUpdateAnswer(answer);
            }else{
                throw  new RuntimeException("保存失败");
            }
            return count;
        } catch (Exception e) {
           throw  new RuntimeException(e);
        }
    }

    @Override
    public int updateContext(Context context, Answer answer) {
        try {
            Answer originAnswer = answerDao.getAnswerByContextId(context.getId());
            long id = originAnswer.getId();
            BeanUtils.copyProperties(answer, originAnswer);
            originAnswer.setId(id);
            originAnswer.setContextId(context.getId());
            contextDao.updateContext(context);
            return answerDao.saveOrUpdateAnswer(originAnswer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Context> getContextPageByKey(Context context, int start, int end) {
        return contextDao.getContextPageByKey(context,start,end);
    }

    @Override
    public int deleteContextById(long id) {
        return contextDao.deleteContextById(id);
    }

    @Override
    public Long getCountByKey(Context context) {
        return contextDao.getCountByKey(context);
    }
}
