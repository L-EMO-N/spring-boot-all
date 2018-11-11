package com.profession.modules.position.service.interfaces;

import com.profession.commons.beans.Position;
import com.profession.commons.beans.PositionIntroduce;
import com.profession.commons.beans.PositionMarket;
import com.profession.commons.beans.PositionPO;
import com.profession.modules.position.param.PositionSearchParam;

import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author LEMON
 * @date 2018/7/3
 */
public interface PositionService {

    /**
     * 保存position相关信息
     */
    void save(Position position, PositionMarket positionMarket, PositionIntroduce positionIntroduce);

    /**
     * 根据id删除相关信息
     */
    Integer deleteById(Long id);



    List<PositionPO> findPositionByKey(PositionSearchParam param);

    Integer getCountByKey(PositionSearchParam param);

    Position getPositionById(long id);

    void update(Position position, PositionIntroduce positionIntroduce, PositionMarket positionMarket);
}
