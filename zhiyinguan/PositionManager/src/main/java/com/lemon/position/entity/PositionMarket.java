package com.lemon.position.entity;

import java.io.Serializable;

/**
 *市场职位 实体类
 * @author LEMON
 * @date 2018/6/14
 */
public class PositionMarket implements Serializable {
    private static final long serialVersionUID = -8325172640330326765L;

    /**id*/
    private Long  pm_id;
    /**城市编码*/
    private String city_code;
    /**城市名称*/
    private String  city_name;
    /**职位id*/
    private Long position_id;
    /**本地平均工资*/
    private Double local_avg_salary;
    /**本地需求量*/
    private Integer local_demand;
    /**平均工资*/
    private Double total_avg_salary;
    /**总共需求量*/
    private Integer total_demand;
    /**创建时间*/
    private  String create_time;
    /**修改时间*/
    private String update_time;


    public Long getPm_id() {
        return pm_id;
    }

    public void setPm_id(Long pm_id) {
        this.pm_id = pm_id;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public Long getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Long position_id) {
        this.position_id = position_id;
    }

    public Double getLocal_avg_salary() {
        return local_avg_salary;
    }

    public void setLocal_avg_salary(Double local_avg_salary) {
        this.local_avg_salary = local_avg_salary;
    }

    public Integer getLocal_demand() {
        return local_demand;
    }

    public void setLocal_demand(Integer local_demand) {
        this.local_demand = local_demand;
    }

    public Double getTotal_avg_salary() {
        return total_avg_salary;
    }

    public void setTotal_avg_salary(Double total_avg_salary) {
        this.total_avg_salary = total_avg_salary;
    }

    public Integer getTotal_demand() {
        return total_demand;
    }

    public void setTotal_demand(Integer total_demand) {
        this.total_demand = total_demand;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "PositionMarket{" +
                "pm_id=" + pm_id +
                ", city_code='" + city_code + '\'' +
                ", city_name='" + city_name + '\'' +
                ", position_id=" + position_id +
                ", local_avg_salary=" + local_avg_salary +
                ", local_demand=" + local_demand +
                ", total_avg_salary=" + total_avg_salary +
                ", total_demand=" + total_demand +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
