package com.lemon.weixin.user.dao;

import com.lemon.weixin.user.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * Created by luolin on 2018/1/28.
 */
public interface UserDao {

        @Select("select * from user where id = #{id}")
       public User getUserById(Long  id);

    /**
     *  保存user
     */
    @Insert("insert into user(username,password,phone) values(#{username},#{password},#{phone})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int  saveUser(User user);


    /**
     *根据id删除User
     * @param id
     * @return
     */
    public int deleteUserByid(long id);


    /**
     * 更新User
     * @param user
     * @return
     */
    public int updaetUser(User user);

    @Select("select * from user where username=#{username} and password = #{password}")
    public User loginUser(User user);


    public int countByUsername(String username);


}
