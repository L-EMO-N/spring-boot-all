package com.profession.commons.mapper;

import com.profession.commons.beans.User;
import com.profession.commons.mybatis.CommonMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends CommonMapper<User> {

    @Select("select * from user t where t.user_name = #{user.userName}")
    User selectUserByUserName(@Param("user") User user);

}