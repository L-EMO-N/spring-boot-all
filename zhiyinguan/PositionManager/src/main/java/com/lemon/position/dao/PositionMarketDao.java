package com.lemon.position.dao;

import com.lemon.position.entity.PositionMarket;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 * @author LEMON
 * @date 2018/6/14
 */
public interface PositionMarketDao {


    /**
     * 添加/更新 positionMarket 信息
     */
    @Insert("replace into  position_market values(#{pm_id},#{city_code},#{city_name},#{position_id},#{local_avg_salary}," +
            "#{local_demand},#{total_avg_salary},#{total_demand},#{create_time},#{update_time})")
    @Options(useGeneratedKeys = true,keyProperty ="pm_id")
    void saveOrUpdate(PositionMarket positionMarket);

    @Delete("delete from position_market where position_id = #{id}")
    Integer deleteByPositionId(Long id);

    @Select("select * from position_market where position_id= #{positionId}")
    List<PositionMarket> getPositionMarkByPositionId(Long positionId);

    @Update("update  position_market set city_code=#{city_code},city_name=#{city_name},local_demand=#{local_demand}," +
            "local_avg_salary = #{local_avg_salary},update_time = #{update_time} where pm_id = #{pm_id}")
    Integer update(PositionMarket positionMarket);
}
