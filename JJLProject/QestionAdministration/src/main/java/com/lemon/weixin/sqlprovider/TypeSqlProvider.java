package com.lemon.weixin.sqlprovider;

import com.lemon.weixin.type.entity.Type;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;

/**
 * Created by luolin on 2018/2/2.
 */
public class TypeSqlProvider {

    public String getTypePage(@Param("type") Type type,@Param("start") int start, @Param("end") int end){
       StringBuffer sqlBuffer = new StringBuffer("");
       sqlBuffer.append(" select * from type");
       if(StringUtils.isNotBlank(type.getName())){
           sqlBuffer.append(" where instr(name,#{type.name}) ");
       }
       sqlBuffer.append(" limit #{start},#{end}");
        return sqlBuffer.toString();
    }



}
