package com.lemon.weixin.resp;

import com.lemon.weixin.common.BaseResponse;

/**
 * Created by luolin on 2018/1/31.
 */
public class DataResp<T> extends BaseResponse{

    private static final long serialVersionUID = 8856376385209576922L;

    private T data;

    private Long AllTotal = 0L;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getAllTotal() {
        return AllTotal;
    }

    public void setAllTotal(Long allTotal) {
        AllTotal = allTotal;
    }
}
