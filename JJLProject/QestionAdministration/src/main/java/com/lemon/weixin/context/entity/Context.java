package com.lemon.weixin.context.entity;

import com.lemon.weixin.util.PageUtil;

import java.io.Serializable;

/**
 * Created by luolin on 2018/1/29.
 */
public class Context extends PageUtil implements  Serializable {


    private static final long serialVersionUID = 8958272545120706484L;


    private Long id;

    //标题
    private String title;

    //类型
    private Long typeId;

    //图片地址
    private String picUrl;

    //排序标志
    private Integer sortFlag;

    private String createTime;

    private String modifyTime;

    private Answer answer;

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getSortFlag() {
        return sortFlag;
    }
    public void setSortFlag(Integer sortFlag) {
        this.sortFlag = sortFlag;
    }


    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Context{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", typeId=" + typeId +
                ", picUrl='" + picUrl + '\'' +
                ", sortFlag=" + sortFlag +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                ", answer=" + answer +
                '}';
    }
}
