package com.lemon.weixin.user.response;

import java.io.Serializable;

/**
 * Created by luolin on 2018/1/30.
 */
public class UserResp<T> implements Serializable{

    private static final long serialVersionUID = -7329464743363986141L;


    private T data;

    private String code;

    private String desc;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
