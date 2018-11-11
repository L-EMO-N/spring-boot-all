package com.lemon.weixin.sqlprovider;

import com.lemon.weixin.context.entity.Context;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/2/5
 */
public class ContextSqlProvider {

        public String  getContextPageByKey(@Param("context") Context context, @Param("start") int start,@Param("end") int end){

            return new SQL(){{
                SELECT( " * ");
                FROM("context");
                if(StringUtils.isNotBlank(context.getTitle())){
                    WHERE(" instr(title,#{context.title})");
                }
                if(context.getTypeId() != null){
                    WHERE("type_id = #{context.typeId}");
                }

                ORDER_BY("id desc limit #{start},#{end}");

            }}.toString();

        }
}
