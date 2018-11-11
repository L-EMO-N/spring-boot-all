package com.profession.commons.beans;

import java.io.Serializable;

/**
 整合position相关属性实体类
 * 用于前端传数据传输的封装
 * @author LEMON
 * @date 2018/7/3
 */
public class PositionPO  implements Serializable {
    private static final long serialVersionUID = 8670917190573728913L;

    /**职位id*/
    private Long positionId;
    /**职位名称*/
    private String positionName;
    /**一线薪资*/
    private Double oneLineSalary;
    /**社会需求*/
    private Integer totalDemand;



    private Long id;

    private Long piPositionId;
    /**职位内容*/
    private String introduce;
    /**职位要求*/
    private String requirement;
    /**名词解释*/
    private String nounInterpretation;
    /**晋升空间*/
    private String direction;



    private Long pmId;

    private Long pmPositionId;
    /**地区*/
    private String cityCode;

    private String cityName;

    private Double localAvgSalary;

    private Double totalAvgSalary;
    /**需求量*/
    private Integer localDemand;

    private Integer pmTotalDemand;



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

    public Double getOneLineSalary() {
        return oneLineSalary;
    }

    public void setOneLineSalary(Double oneLineSalary) {
        this.oneLineSalary = oneLineSalary;
    }

    public Integer getTotalDemand() {
        return totalDemand;
    }

    public void setTotalDemand(Integer totalDemand) {
        this.totalDemand = totalDemand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPiPositionId() {
        return piPositionId;
    }

    public void setPiPositionId(Long piPositionId) {
        this.piPositionId = piPositionId;
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

    public String getNounInterpretation() {
        return nounInterpretation;
    }

    public void setNounInterpretation(String nounInterpretation) {
        this.nounInterpretation = nounInterpretation;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getPmId() {
        return pmId;
    }

    public void setPmId(Long pmId) {
        this.pmId = pmId;
    }

    public Long getPmPositionId() {
        return pmPositionId;
    }

    public void setPmPositionId(Long pmPositionId) {
        this.pmPositionId = pmPositionId;
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

    public Double getLocalAvgSalary() {
        return localAvgSalary;
    }

    public void setLocalAvgSalary(Double localAvgSalary) {
        this.localAvgSalary = localAvgSalary;
    }

    public Double getTotalAvgSalary() {
        return totalAvgSalary;
    }

    public void setTotalAvgSalary(Double totalAvgSalary) {
        this.totalAvgSalary = totalAvgSalary;
    }

    public Integer getLocalDemand() {
        return localDemand;
    }

    public void setLocalDemand(Integer localDemand) {
        this.localDemand = localDemand;
    }

    public Integer getPmTotalDemand() {
        return pmTotalDemand;
    }

    public void setPmTotalDemand(Integer pmTotalDemand) {
        this.pmTotalDemand = pmTotalDemand;
    }

}
