package com.profession.commons.beans;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * 职位实体类
 * 没用jpa的注解
 * @author LENON
 * @date 2018/7/3
 */
public class Position  implements Serializable {

    private static final long serialVersionUID = -4184485394771644732L;

    /**id*/
    private Long positionId;
    /**职位名称*/
    private  String positionName;
    /**职位类型*/
    private Integer positionType;

    private Integer hot;

    private String learningTime;
    /**热门城市*/
    private String hotCity;
    /**一线薪资*/
    private Double oneLineSalary;
    /**二线薪资*/
    private Double twoLineSalary;
    /**爬虫标志*/
    private Integer  crawlerFlag;
    /**总共需求*/
    private Integer totalDemand;
    /**创建时间*/
    private String createTime;
    /**修改时间*/
    private String updateTime;

    @Transient
    private PositionIntroduce positionIntroduce;

    @Transient
    private List<PositionMarket> positionMarketList;


    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getPositionType() {
        return positionType;
    }

    public void setPositionType(Integer positionType) {
        this.positionType = positionType;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getLearningTime() {
        return learningTime;
    }

    public void setLearningTime(String learningTime) {
        this.learningTime = learningTime;
    }

    public String getHotCity() {
        return hotCity;
    }

    public void setHotCity(String hotCity) {
        this.hotCity = hotCity;
    }

    public Double getOneLineSalary() {
        return oneLineSalary;
    }

    public void setOneLineSalary(Double oneLineSalary) {
        this.oneLineSalary = oneLineSalary;
    }

    public Double getTwoLineSalary() {
        return twoLineSalary;
    }

    public void setTwoLineSalary(Double twoLineSalary) {
        this.twoLineSalary = twoLineSalary;
    }

    public Integer getCrawlerFlag() {
        return crawlerFlag;
    }

    public void setCrawlerFlag(Integer crawlerFlag) {
        this.crawlerFlag = crawlerFlag;
    }

    public Integer getTotalDemand() {
        return totalDemand;
    }

    public void setTotalDemand(Integer totalDemand) {
        this.totalDemand = totalDemand;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
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
}
