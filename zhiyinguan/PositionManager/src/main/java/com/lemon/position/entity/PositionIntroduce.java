package com.lemon.position.entity;

import java.io.Serializable;

/**
 * 职位详细信息 实体类
 * @author LEMON
 * @date 2018/6/14
 */
public class PositionIntroduce implements Serializable {


    private static final long serialVersionUID = 3780144680977886080L;

    /**id*/
    private Long id;
    /**职位id*/
    private Long position_id;
    /**职位内容*/
    private String introduce;
    /**职位要求*/
    private String requirement;
    /**名词解释*/
    private String noun_interpretation;
    /**晋升空间*/
    private String direction;
    /**创建时间*/
    private String create_time;
    /**修改时间*/
    private String update_time;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Long position_id) {
        this.position_id = position_id;
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
        return "PositionIntroduce{" +
                "id=" + id +
                ", position_id=" + position_id +
                ", introduce='" + introduce + '\'' +
                ", requirement='" + requirement + '\'' +
                ", noun_interpretation='" + noun_interpretation + '\'' +
                ", direction='" + direction + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
