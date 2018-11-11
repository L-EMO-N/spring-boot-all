package com.lemon.weixin.type.entity;

import java.io.Serializable;

/**
 * Created by luolin on 2018/1/30.
 */
public class Type  implements Serializable{

    private static final long serialVersionUID = -6543558558045508737L;

    private Long id;

    private String name;

    private String createTime;

    private String modifyTime;

    private String testId;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
