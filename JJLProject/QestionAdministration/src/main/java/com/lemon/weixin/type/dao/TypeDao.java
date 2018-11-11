package com.lemon.weixin.type.dao;

import com.lemon.weixin.sqlprovider.TypeSqlProvider;
import com.lemon.weixin.type.entity.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by luolin on 2018/1/30.
 */
public interface TypeDao {

    /**
     * 保存type
     */
    @Insert("insert into type(name,create_time,modify_time)values(#{name},#{createTime},#{modifyTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int insertType(Type type);

    /**
     * 根据id删除type
     */
    @Delete("delete from type where id=#{id}")
    public int deleteTypeById(Long id);

    /**
     * 更新type
     */
    @Update("<script>update type set <if test='name  != null and name != \"\" '>name=#{name} ,</if> modify_Time = now() where id=#{id} </script>")
    public int updateType(Type type);

    /**
     *根据条件分页查询type
     */
    @SelectProvider(type = TypeSqlProvider.class,method = "getTypePage")
    public List<Type> getTypePage(@Param("type") Type type, @Param("start") int start, @Param("end") int end);

    /**
     *根据姓名计数
     */
  @Select("select count(*) from type where name =#{name}")
    public int getCountByName(String name);

    /**
     *根据id查询
     */
    @Select("select * from type where id =#{id}")
    public Type getTypeById(long id);

    @Select("select * from type where name =#{name} and id <>#{id} limit 0,1")
    @Results({
                @Result(property = "createTime",column = "create_time"),
                @Result(property ="modifyTime",column = "modify_time")
    })
    Type getTypeByNameAndId(@Param("id") long id, @Param("name") String name);
}
