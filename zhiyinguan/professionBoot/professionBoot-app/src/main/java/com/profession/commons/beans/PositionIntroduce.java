package com.profession.commons.beans;

import java.io.Serializable;

/**
 * 职位介绍实体类
 * @author LEMON
 * @date 2018/7/3
 */
public class PositionIntroduce  implements Serializable {
    private static final long serialVersionUID = -6917157926033727551L;

    /**id*/
    private Long id;
    /**职位id*/
    private Long positionId;
    /**职位内容*/
    private String introduce;
    /**职位要求*/
    private String requirement;
    /**名词解释*/
    private String nounInterpretation;
    /**晋升空间*/
    private String direction;
    /**创建时间*/
    private String createTime;
    /**修改时间*/
    private String updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
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
