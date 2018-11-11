package com.lemon.weixin.context.dao;

import com.lemon.weixin.context.entity.Context;
import com.lemon.weixin.sqlprovider.ContextSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 */
public interface contextDao {

    @Select("select * from context where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "type_id",property = "typeId"),
            @Result(column = "pic_url",property = "picUrl"),
            @Result(column = "sort_flag",property = "sortFlag"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "modify_time",property = "modifyTime"),
            @Result(column = "id",property = "answer",one = @One(
                    select = "com.lemon.weixin.context.dao.AnswerDao.getAnswerByContextId",fetchType = FetchType.EAGER
            ))
        }
    )
    public Context getContextById(Long id);

    //保存
    @Insert("insert into context(title,type_id,pic_url,sort_flag,create_time,modify_time) values(#{title},#{typeId},#{picUrl},#{sortFlag},#{createTime},#{modifyTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int saveContext(Context context);

    //    更新context
  @Update("update context set title=#{title},type_id=#{typeId},pic_url=#{picUrl},sort_flag=#{sortFlag},modify_time=now() where id=#{id}")
    public int updateContext(Context context);

    //    根据条件分页查询context
    @SelectProvider(type = ContextSqlProvider.class,method ="getContextPageByKey")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "type_id",property = "typeId"),
            @Result(column = "pic_url",property = "picUrl"),
            @Result(column = "sort_flag",property = "sortFlag"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "modify_time",property = "modifyTime"),
       }
    )
    public List<Context> getContextPageByKey(@Param("context") Context context , @Param("start") int start,@Param("end") int end);


    @Select("<script> select count(*) from context <if test = 'context.title != null and context.title !=\" \" ' >where instr(title,#{context.title})</if></script>")
    Long getCountByKey(@Param("context") Context context);

    //    根据id删除context
    @Delete("delete from context where id = #{id}")
    public int deleteContextById(long id);
}
