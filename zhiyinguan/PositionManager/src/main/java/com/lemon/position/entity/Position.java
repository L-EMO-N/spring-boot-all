package com.lemon.position.entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * position_introduce
 *职位基本信息 实体类
 * @author LEMON
 * @date 2018/6/12
 */
public class Position  implements Serializable{

    private static final long serialVersionUID = -9145125306723649400L;

    /**id*/
    private Long position_id;
    /**职位名称*/
    private  String position_name;
    /**职位类型*/
    private Integer position_type;

    private Integer hot;

    private String learning_time;
    /**热门城市*/
    private String hot_city;
    /**一线薪资*/
    private Double one_line_salary;
    /**二线薪资*/
    private Double two_line_salary;
    /**爬虫标志*/
    private Integer  crawler_flag;
    /**总共需求*/
    private Integer total_demand;
    /**创建时间*/
    private String create_time;
    /**修改时间*/
    private String update_time;

    private PositionIntroduce positionIntroduce;

    private List<PositionMarket> positionMarketList;


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

    public Integer getPosition_type() {
        return position_type;
    }

    public void setPosition_type(Integer position_type) {
        this.position_type = position_type;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getLearning_time() {
        return learning_time;
    }

    public void setLearning_time(String learning_time) {
        this.learning_time = learning_time;
    }

    public String getHot_city() {
        return hot_city;
    }

    public void setHot_city(String hot_city) {
        this.hot_city = hot_city;
    }

    public Double getOne_line_salary() {
        return one_line_salary;
    }

    public void setOne_line_salary(Double one_line_salary) {
        this.one_line_salary = one_line_salary;
    }

    public Double getTwo_line_salary() {
        return two_line_salary;
    }

    public void setTwo_line_salary(Double two_line_salary) {
        this.two_line_salary = two_line_salary;
    }

    public Integer getCrawler_flag() {
        return crawler_flag;
    }

    public void setCrawler_flag(Integer crawler_flag) {
        this.crawler_flag = crawler_flag;
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

    public PositionIntroduce getPositionIntroduce() {
        return positionIntroduce;
    }

    public void setPositionIntroduce(PositionIntroduce positionIntroduce) {
        this.positionIntroduce = positionIntroduce;
    }

    public List<PositionMarket> getPositionMarketList() {
        return positionMarketList;
    }

    public void setPositionMarketList(List<PositionMarket> positionMarketList) {
        this.positionMarketList = positionMarketList;
    }

    @Override
    public String toString() {
        return "Position{" +
                "position_id=" + position_id +
                ", position_name='" + position_name + '\'' +
                ", position_type=" + position_type +
                ", hot=" + hot +
                ", learning_time='" + learning_time + '\'' +
                ", hot_city='" + hot_city + '\'' +
                ", one_line_salary=" + one_line_salary +
                ", two_line_salary=" + two_line_salary +
                ", crawler_flag=" + crawler_flag +
                ", total_demand=" + total_demand +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
