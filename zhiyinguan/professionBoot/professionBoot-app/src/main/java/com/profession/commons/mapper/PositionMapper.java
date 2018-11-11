package com.profession.commons.mapper;

import com.profession.commons.beans.Position;
import com.profession.commons.beans.PositionPO;
import com.profession.commons.mybatis.CommonMapper;
import com.profession.modules.position.param.PositionSearchParam;
import com.profession.modules.position.sqlprovider.PositionSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author LEMON
 * @date 2018/7/3
 */
public interface PositionMapper  extends CommonMapper<Position> {

    /**
     *插入 更新
     */
    @Insert("replace into position (position_id,position_name, position_type, hot, learning_time, hot_city, " +
            "one_line_salary, two_line_salary ,create_time, update_time) " +
            "values ( #{position.positionId},#{position.positionName}, #{position.positionType}, #{position.hot}, #{position.learningTime}," +
            " #{position.hotCity},#{position.oneLineSalary}, #{position.twoLineSalary}, " +
            " #{position.createTime}, #{position.updateTime})")
    @Options(useGeneratedKeys = true,keyProperty = "position.positionId")
    Integer savePosition(@Param("position") Position position);


    /**
     *根据id删除
     */
    @Delete("delete from position where position_id = #{id}")
    Integer deleteById(Long id);

    /**
     *根据条件 分页查询
     */
    @SelectProvider(type = PositionSqlProvider.class,method = "findPostionByKey")
    List<PositionPO> findPostionByKey(@Param("param") PositionSearchParam param);

    /**
     *根据条件计数
     */
    @SelectProvider(type = PositionSqlProvider.class,method = "getCountByKey")
    Integer getCountByKey(@Param("param") PositionSearchParam param);

    /**
     *根据id查询position
     */
    @Select("select * from position where position_id = #{id}")
    @Results({
            @Result(id = true,column = "position_id",property = "position_id"),
            @Result(column = "position_id",property = "positionIntroduce",one = @One(
                    select = "com.lemon.position.dao.PositionIntroduceDao.getPositionIntroduceByPositionId",fetchType = FetchType.EAGER
            )),
            @Result(column = "position_id",property = "positionMarketList",many = @Many(
                    select ="com.lemon.position.dao.PositionMarketDao.getPositionMarkByPositionId",fetchType = FetchType.EAGER
            ))
    })
    Position getPositionById(long id);

    @Update(" update position set position_name = #{position.positionName},one_line_salary=#{position.oneLineSalary}," +
            "twoLineSalary = #{position.twoLineSalary},total_demand=#{position.totalDemand} ,update_time = #{position.updateTime}" +
            "where position_id = #{position.positionId}")
    Integer updatePosition(@Param("position") Position position);
}


