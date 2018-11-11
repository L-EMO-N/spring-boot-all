package com.profession.commons.utils;

import java.io.Serializable;

/**
 * 页码 工具类
 * @author LEMON
 * @date 2018/7/3
 */
public class PageUtil implements Serializable {
    private static final long serialVersionUID = 7645720191370446724L;

    private Integer pageNumber = 1;

    private Integer pageSize = 10;

    private Integer total;

    private  Integer start;

    private Integer end;


    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
