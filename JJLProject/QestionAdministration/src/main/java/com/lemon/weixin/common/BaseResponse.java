package com.lemon.weixin.common;

import java.io.Serializable;

/**
 * Created by luolin on 2018/1/31.
 */
public class BaseResponse  implements Serializable{

    private static final long serialVersionUID = -1985065656982401181L;

    /**
     *返回编码
     *0000 表示成功
     */
    private String code;

//    返回描述
    private String desc;


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
