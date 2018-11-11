package com.profession.commons.mapper;

import com.profession.commons.beans.PositionIntroduce;
import com.profession.commons.mybatis.CommonMapper;
import org.apache.ibatis.annotations.*;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author LEMON
 * @date 2018/7/3
 *
 * INSERT INTO `zhiyinguan`.`position_introduce` (`id`, `position_id`, `introduce`, `requirement`, `noun_interpretation`, `direction`, `create_time`, `update_time`)
 */
public interface PositionIntroduceMapper  extends CommonMapper<PositionIntroduce>{
    @Insert("replace into position_introduce values (#{id},#{positionId},#{introduce},#{requirement}," +
            "#{nounInterpretation},#{direction},#{createTime},#{updateTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void saveOrUpdate(PositionIntroduce positionIntroduce);

    @Delete("delete from position_introduce where position_id = #{id} ")
    Integer deleteByPostionId(Long id);


    @Select("select * from position_introduce where position_id=#{positionId}")
    PositionIntroduce getPositionIntroduceByPositionId(Long positionId);

    @Update("update position_introduce set introduce = #{introduce},requirement=#{requirement},noun_interpretation=#{nounInterpretation}," +
            "direction = #{direction},updateTime=#{updateTime} where id = #{id} ")
    Integer update(PositionIntroduce positionIntroduce);
}
