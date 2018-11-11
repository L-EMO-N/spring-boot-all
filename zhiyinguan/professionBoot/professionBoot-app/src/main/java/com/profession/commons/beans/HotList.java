package com.profession.commons.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dengjie0707 on 2018/7/3.
 */
public class HotList implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;//热榜编号
    private User user_id;//用户信息
    private String content;//内容
    private String comment;//评论数
    private String browse;//浏览数
    private String likes;//点赞数
    private String  collect;//收藏数
    private Date create_time;//创建时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBrowse() {
        return browse;
    }

    public void setBrowse(String browse) {
        this.browse = browse;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
