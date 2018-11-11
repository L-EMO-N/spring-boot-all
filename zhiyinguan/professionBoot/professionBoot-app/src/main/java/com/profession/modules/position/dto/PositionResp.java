package com.profession.modules.position.dto;

/**
 * DTO 交互类
 *
 * @author LEMON
 * @date 2018/7/3
 */
public class PositionResp<T> {

    private  String code;

    private String desc;

    private T data;

    private Integer total = 0;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
