package com.lemon.position.sqlprovider;

import com.lemon.position.param.PositionSearchParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;

/**
 * positionDao
 * SQL 扩展类
 *
 * @author LEMON
 */
public class PositionSqlProvider {

    /**
     * 根据条件分页查询
     * @param param
     * @return
     */
    public  String findPostionByKey(@Param("param") PositionSearchParam param){

            StringBuffer sb = new StringBuffer("select *,pm.total_demand as pm_total_demand from position p ");
            sb.append(" left join position_introduce pi on p.position_id = pi.position_id")
                    .append(" left join position_market pm on p.position_id = pm.position_id ")
                    .append("  where   1= 1  ");
            sb.append(conditionSql(param));
            sb.append(" group by p.position_id ");
            if(StringUtils.isNotBlank(param.getSort())){
                sb.append(" order by  ").append(param.getSort()).append(" desc ");
            }
            sb.append(" limit #{param.start},#{param.end} ");
            return sb.toString();
        }


    /**
     * 根据条件技计数  用于分页
     * @param param
     * @return
     */
    public String getCountByKey(@Param("param") PositionSearchParam param){

            StringBuffer sqlBuffer = new StringBuffer(" select count(distinct(p.position_id)) from position p ");
            sqlBuffer.append(" left join position_market pm on p.position_id = pm.position_id  where 1=1 ");
            sqlBuffer.append(conditionSql(param));
            return sqlBuffer.toString();
        }

        public StringBuffer conditionSql(@Param("param") PositionSearchParam param){
            StringBuffer sb = new StringBuffer("");
            if(param.getType() != null){
                sb.append("   and  p.position_type  = #{param.type} ");
            }
            if(StringUtils.isNotBlank(param.getPositionName())){
                sb.append(" and  instr(p.position_name,#{param.positionName})");
            }
            if(StringUtils.isNotBlank(param.getCityCode())){
                sb.append(" and pm.city_code = #{param.cityCode} ");
            }
            return  sb;
        }
}
