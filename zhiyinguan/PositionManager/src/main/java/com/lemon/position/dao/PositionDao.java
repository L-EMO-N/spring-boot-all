package com.lemon.position.dao;

import com.lemon.position.entity.Position;
import com.lemon.position.entity.PositionPO;
import com.lemon.position.param.PositionSearchParam;
import com.lemon.position.sqlprovider.PositionSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author LEMON
 * @date 2018/6/13
 */
public interface PositionDao {

        /** 
         *插入 更新
        */
     @Insert("replace into position (position_id,position_name, position_type, hot, learning_time, hot_city, " +
             "one_line_salary, two_line_salary ,create_time, update_time) " +
             "values ( #{position.position_id},#{position.position_name}, #{position.position_type}, #{position.hot}, #{position.learning_time}," +
             " #{position.hot_city},#{position.one_line_salary}, #{position.two_line_salary}, " +
             " #{position.create_time}, #{position.update_time})")
     @Options(useGeneratedKeys = true,keyProperty = "position.position_id")
    Integer savePosition(@Param("position") Position position);


    /**
     *根据id删除
     */
     @Delete("delete from position where position_id = #{id}")
    Integer delete(Long id);

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

    @Update(" update position set position_name = #{position.position_name},one_line_salary=#{position.one_line_salary}," +
            "two_line_salary = #{position.two_line_salary},total_demand=#{position.total_demand} ,update_time = #{position.update_time}" +
            "where position_id = #{position.position_id}")
    Integer updatePosition(@Param("position") Position position);
}


