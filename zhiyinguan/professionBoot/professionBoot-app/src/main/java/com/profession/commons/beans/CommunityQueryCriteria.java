package com.profession.commons.beans;

import java.util.Date;

/**
 * Created by dengjie0707 on 2018/7/3.
 *
 * 社区管理查询条件实体类
 */
public class CommunityQueryCriteria {
    private Date start_time;//查询起始时间
    private Date end_time;//查询终止时间
    private String type;//类型
    private int show_num;//展示数
    private String sort_type;//排序方式

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getShow_num() {
        return show_num;
    }

    public void setShow_num(int show_num) {
        this.show_num = show_num;
    }

    public String getSort_type() {
        return sort_type;
    }

    public void setSort_type(String sort_type) {
        this.sort_type = sort_type;
    }
}
