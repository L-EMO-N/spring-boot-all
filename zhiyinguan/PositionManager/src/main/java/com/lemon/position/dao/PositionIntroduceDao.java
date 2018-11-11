package com.lemon.position.dao;

import com.lemon.position.entity.PositionIntroduce;
import org.apache.ibatis.annotations.*;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author LEMON
 * @date 2018/6/14
 *
 * INSERT INTO `zhiyinguan`.`position_introduce` (`id`, `position_id`, `introduce`, `requirement`, `noun_interpretation`, `direction`, `create_time`, `update_time`)
 */
public interface PositionIntroduceDao {
    @Insert("replace into position_introduce values (#{id},#{position_id},#{introduce},#{requirement}," +
            "#{noun_interpretation},#{direction},#{create_time},#{update_time})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void saveOrUpdate(PositionIntroduce positionIntroduce);

    @Delete("delete from position_introduce where position_id = #{id} ")
    Integer deleteByPostionId(Long id);


    @Select("select * from position_introduce where position_id=#{positionId}")
    PositionIntroduce getPositionIntroduceByPositionId(Long positionId);

    @Update("update position_introduce set introduce = #{introduce},requirement=#{requirement},noun_interpretation=#{noun_interpretation}," +
            "direction = #{direction},update_time=#{update_time} where id = #{id} ")
    Integer update(PositionIntroduce positionIntroduce);
}
