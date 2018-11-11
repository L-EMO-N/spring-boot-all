package com.lemon.weixin.util;

import java.io.Serializable;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/3/1
 */
public class PageUtil   implements Serializable{

    private static final long serialVersionUID = -5681792837871936826L;
    private  Integer pageNumber = 1;

     private Integer pageSize = 10;

     private  Long total = 10L;


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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
