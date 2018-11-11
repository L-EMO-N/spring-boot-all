package com.profession.commons.mapper;

import com.profession.commons.beans.PositionMarket;
import com.profession.commons.mybatis.CommonMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 * @author LEMON
 * @date 2018/7/3
 */
public interface PositionMarketMapper  extends CommonMapper<PositionMarket>{


    /**
     * 添加/更新 positionMarket 信息
     */
    @Insert("replace into  position_market values(#{pmId},#{cityCode},#{cityName},#{positionId},#{localAvgSalary}," +
            "#{localDemand},#{totalAvgSalary},#{totalDemand},#{createTime},#{updateTime})")
    @Options(useGeneratedKeys = true,keyProperty ="pm_id")
    void saveOrUpdate(PositionMarket positionMarket);

    @Delete("delete from position_market where position_id = #{id}")
    Integer deleteByPositionId(Long id);

    @Select("select * from position_market where position_id= #{positionId}")
    List<PositionMarket> getPositionMarkByPositionId(Long positionId);

    @Update("update  position_market set city_code=#{cityCode},city_name=#{cityName},local_demand=#{localDemand}," +
            "local_avg_salary = #{localAvgSalary},update_time = #{updateTime} where pm_id = #{pmId}")
    Integer update(PositionMarket positionMarket);
}
