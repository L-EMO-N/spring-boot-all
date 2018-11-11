package com.lemon.position.service;

import com.lemon.position.entity.Position;
import com.lemon.position.entity.PositionIntroduce;
import com.lemon.position.entity.PositionMarket;
import com.lemon.position.entity.PositionPO;
import com.lemon.position.param.PositionSearchParam;

import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author LEMON
 * @date 2018/6/12
 */
public interface PositionService {

    /**
     * 保存Postion
    */
    Integer savePositon(Position position);

    /**
     * 保存position相关信息
     */
    void save(Position position,PositionMarket positionMarket,PositionIntroduce positionIntroduce);

    /**
     * 根据id删除相关信息
     */
    Integer deleteById(Long id);



    List<PositionPO> findPositionByKey(PositionSearchParam param);

    Integer getCountByKey(PositionSearchParam param);

    Position getPositionById(long id);

    void update(Position position, PositionIntroduce positionIntroduce, PositionMarket positionMarket);
}
