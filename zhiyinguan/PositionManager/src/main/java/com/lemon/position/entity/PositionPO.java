package com.lemon.position.entity;

import java.io.Serializable;

/**
 *整合position相关属性实体类
 * 用于前端传数据传输的封装
 * @author LEMON
 * @date 2018/6/14
 */
public class PositionPO implements Serializable {
    private static final long serialVersionUID = 2111379829997122609L;
    /**职位id*/
    private Long position_id;
    /**职位名称*/
    private String position_name;
    /**一线薪资*/
    private Double one_line_salary;
    /**社会需求*/
    private Integer total_demand;



    private Long id;

    private Long pi_position_id;
    /**职位内容*/
    private String introduce;
    /**职位要求*/
    private String requirement;
    /**名词解释*/
    private String noun_interpretation;
    /**晋升空间*/
    private String direction;



    private Long pm_id;

    private Long pm_position_id;
    /**地区*/
    private String city_code;

    private String city_name;

    private Double local_avg_salary;

    private Double total_avg_salary;
    /**需求量*/
    private Integer local_demand;

    private Integer pm_total_demand;

    public Long getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Long position_id) {
        this.position_id = position_id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public Double getOne_line_salary() {
        return one_line_salary;
    }

    public void setOne_line_salary(Double one_line_salary) {
        this.one_line_salary = one_line_salary;
    }

    public Integer getTotal_demand() {
        return total_demand;
    }

    public void setTotal_demand(Integer total_demand) {
        this.total_demand = total_demand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPi_position_id() {
        return pi_position_id;
    }

    public void setPi_position_id(Long pi_position_id) {
        this.pi_position_id = pi_position_id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getNoun_interpretation() {
        return noun_interpretation;
    }

    public void setNoun_interpretation(String noun_interpretation) {
        this.noun_interpretation = noun_interpretation;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getPm_id() {
        return pm_id;
    }

    public void setPm_id(Long pm_id) {
        this.pm_id = pm_id;
    }

    public Long getPm_position_id() {
        return pm_position_id;
    }

    public void setPm_position_id(Long pm_position_id) {
        this.pm_position_id = pm_position_id;
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

    public Double getLocal_avg_salary() {
        return local_avg_salary;
    }

    public void setLocal_avg_salary(Double local_avg_salary) {
        this.local_avg_salary = local_avg_salary;
    }

    public Double getTotal_avg_salary() {
        return total_avg_salary;
    }

    public void setTotal_avg_salary(Double total_avg_salary) {
        this.total_avg_salary = total_avg_salary;
    }

    public Integer getLocal_demand() {
        return local_demand;
    }

    public void setLocal_demand(Integer local_demand) {
        this.local_demand = local_demand;
    }

    public Integer getPm_total_demand() {
        return pm_total_demand;
    }

    public void setPm_total_demand(Integer pm_total_demand) {
        this.pm_total_demand = pm_total_demand;
    }

    @Override
    public String toString() {
        return "PositionPO{" +
                "position_id=" + position_id +
                ", position_name='" + position_name + '\'' +
                ", one_line_salary=" + one_line_salary +
                ", total_demand=" + total_demand +
                ", id=" + id +
                ", pi_position_id=" + pi_position_id +
                ", introduce='" + introduce + '\'' +
                ", requirement='" + requirement + '\'' +
                ", noun_interpretation='" + noun_interpretation + '\'' +
                ", direction='" + direction + '\'' +
                ", pm_id=" + pm_id +
                ", pm_position_id=" + pm_position_id +
                ", city_code='" + city_code + '\'' +
                ", city_name='" + city_name + '\'' +
                ", local_avg_salary=" + local_avg_salary +
                ", total_avg_salary=" + total_avg_salary +
                ", local_demand=" + local_demand +
                ", pm_total_demand=" + pm_total_demand +
                '}';
    }
}
