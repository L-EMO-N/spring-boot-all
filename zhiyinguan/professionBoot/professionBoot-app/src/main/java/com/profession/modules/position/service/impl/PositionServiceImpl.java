package com.profession.modules.position.service.impl;

import com.profession.commons.beans.Position;
import com.profession.commons.beans.PositionIntroduce;
import com.profession.commons.beans.PositionMarket;
import com.profession.commons.beans.PositionPO;
import com.profession.commons.mapper.PositionIntroduceMapper;
import com.profession.commons.mapper.PositionMapper;
import com.profession.commons.mapper.PositionMarketMapper;
import com.profession.modules.position.param.PositionSearchParam;
import com.profession.modules.position.service.interfaces.PositionService;
import org.apache.commons.lang3.StringUtils;
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
 * @date 2018/7/3
 */
@Service
@Transactional
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private PositionIntroduceMapper positionIntroduceMapper;

    @Autowired
    private PositionMarketMapper positionMarketMapper;


    /**
     *初始保存position相关信息
     */
    @Override
    public void save(Position position,PositionMarket positionMarket,PositionIntroduce positionIntroduce) {
        //保存posititon 并获得id
        String createTime = LocalDateTime.now()+"";
        position.setCreateTime(createTime);
        position.setUpdateTime(createTime);
        position.setPositionType(1);
        positionMapper.savePosition(position);
        Long positonId = position.getPositionId();
        //id为null  则保存不成功 直接返回
        if(positonId == null){
            throw  new RuntimeException();
        }
        //保存PositionIntroduce
        positionIntroduce.setPositionId(positonId);
//        positionIntroduce.setId(positionPO.getId());
        positionIntroduce.setCreateTime(createTime);
        position.setUpdateTime(createTime);
        positionIntroduceMapper.saveOrUpdate(positionIntroduce);
        //保存 PositionMarket
        //是否有数据 有则save
        if(StringUtils.isNotBlank(positionMarket.getCityCode()) &&(positionMarket.getTotalAvgSalary() != null
                || position.getTotalDemand() != null)){
            positionMarket.setPositionId(positonId);
            positionMarket.setCreateTime(createTime);
            positionMarket.setUpdateTime(createTime);
            positionMarketMapper.saveOrUpdate(positionMarket);
        }
    }
    /**
     * 根据id删除相关信息
     *
     * @param id
     */
    @Override
    public Integer deleteById(Long id) {

        positionIntroduceMapper.deleteByPostionId(id);

        positionMarketMapper.deleteByPositionId(id);

        return positionMapper.deleteById(id);
    }



    @Override
    public List<PositionPO> findPositionByKey(PositionSearchParam param) {

        return positionMapper.findPostionByKey(param);
    }

    @Override
    public Integer getCountByKey(PositionSearchParam param) {
        return positionMapper.getCountByKey(param);
    }

    /**
     * 根据id获得position
     * @return
     */
    @Override
    public Position getPositionById(long id) {
        return positionMapper.getPositionById(id);
    }

    @Override
    public void update(Position position, PositionIntroduce positionIntroduce, PositionMarket positionMarket) {
        String nowTime = LocalDateTime.now()+"";
        position.setUpdateTime(nowTime);
        positionIntroduce.setUpdateTime(nowTime);
        positionMarket.setUpdateTime(nowTime);
        positionMapper.updatePosition(position);
        positionIntroduceMapper.update(positionIntroduce);
        positionMarketMapper.update(positionMarket);
    }
}
