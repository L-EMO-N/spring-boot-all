package com.profession.commons.beans;

import java.io.Serializable;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author LEMON
 * @date 2018/7/3
 */
public class PositionMarket  implements Serializable{

    private static final long serialVersionUID = -7564460157902781673L;
    /**id*/
    private Long  pmId;
    /**城市编码*/
    private String cityCode;
    /**城市名称*/
    private String  cityName;
    /**职位id*/
    private Long positionId;
    /**本地平均工资*/
    private Double localAvgSalary;
    /**本地需求量*/
    private Integer localDemand;
    /**平均工资*/
    private Double totalAvgSalary;
    /**总共需求量*/
    private Integer totalDemand;
    /**创建时间*/
    private  String createTime;
    /**修改时间*/
    private String updateTime;


    public Long getPmId() {
        return pmId;
    }

    public void setPmId(Long pmId) {
        this.pmId = pmId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Double getLocalAvgSalary() {
        return localAvgSalary;
    }

    public void setLocalAvgSalary(Double localAvgSalary) {
        this.localAvgSalary = localAvgSalary;
    }

    public Integer getLocalDemand() {
        return localDemand;
    }

    public void setLocalDemand(Integer localDemand) {
        this.localDemand = localDemand;
    }

    public Double getTotalAvgSalary() {
        return totalAvgSalary;
    }

    public void setTotalAvgSalary(Double totalAvgSalary) {
        this.totalAvgSalary = totalAvgSalary;
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
}
