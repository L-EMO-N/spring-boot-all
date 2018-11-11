package com.lemon.position.service.impl;

import com.lemon.position.dao.PositionDao;
import com.lemon.position.dao.PositionIntroduceDao;
import com.lemon.position.dao.PositionMarketDao;
import com.lemon.position.entity.*;
import com.lemon.position.param.PositionSearchParam;
import com.lemon.position.service.PositionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author LEMON
 * @date 2018/6/12
 */
@Service
@Transactional
public class PostionServiceImpl implements PositionService{

    @Autowired
    private PositionDao positionDao;

    @Autowired
    private PositionIntroduceDao positionIntroduceDao;

    @Autowired
    private PositionMarketDao positionMarketDao;

    /**保存position*/
    @Override
    public Integer savePositon(Position position) {
        return positionDao.savePosition(position);
    }

    /**
     *初始保存position相关信息
     */
    @Override
    public void save(Position position,PositionMarket positionMarket,PositionIntroduce positionIntroduce) {
        //保存posititon 并获得id
        String createTime = LocalDateTime.now()+"";
        position.setCreate_time(createTime);
        position.setUpdate_time(createTime);
        position.setPosition_type(1);
        positionDao.savePosition(position);
        Long positonId = position.getPosition_id();
        //id为null  则保存不成功 直接返回
        if(positonId == null){
            throw  new RuntimeException();
        }
        //保存PositionIntroduce
        positionIntroduce.setPosition_id(positonId);
//        positionIntroduce.setId(positionPO.getId());
        positionIntroduce.setCreate_time(createTime);
        position.setUpdate_time(createTime);
        positionIntroduceDao.saveOrUpdate(positionIntroduce);
        //保存 PositionMarket
        //是否有数据 有则save
        if(StringUtils.isNotBlank(positionMarket.getCity_code()) &&(positionMarket.getTotal_avg_salary() != null
                || position.getTotal_demand() != null)){
            positionMarket.setPosition_id(positonId);
            positionMarket.setCreate_time(createTime);
            positionMarket.setUpdate_time(createTime);
            positionMarketDao.saveOrUpdate(positionMarket);
        }
    }
    /**
     * 根据id删除相关信息
     *
     * @param id
     */
    @Override
    public Integer deleteById(Long id) {

        positionIntroduceDao.deleteByPostionId(id);

        positionMarketDao.deleteByPositionId(id);

        return positionDao.delete(id);
    }



    @Override
    public List<PositionPO> findPositionByKey(PositionSearchParam param) {

        return positionDao.findPostionByKey(param);
    }

    @Override
    public Integer getCountByKey(PositionSearchParam param) {
        return positionDao.getCountByKey(param);
    }

    /**
     * 根据id获得position
     * @return
     */
    @Override
    public Position getPositionById(long id) {
        return positionDao.getPositionById(id);
    }

    @Override
    public void update(Position position, PositionIntroduce positionIntroduce, PositionMarket positionMarket) {
            String nowTime = LocalDateTime.now()+"";
            position.setUpdate_time(nowTime);
            positionIntroduce.setUpdate_time(nowTime);
            positionMarket.setUpdate_time(nowTime);
            positionDao.updatePosition(position);
            positionIntroduceDao.update(positionIntroduce);
            positionMarketDao.update(positionMarket);
    }
}
