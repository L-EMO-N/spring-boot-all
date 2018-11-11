package com.profession.modules.position.param;

import com.profession.commons.utils.PageUtil;

/**
 * 参数传递类
 * @author LEMON
 * @date 2018/7/3
 */
public class PositionSearchParam extends PageUtil {
    private static final long serialVersionUID = 6991063255518120279L;


    private  Integer type;

    private String  positionName;

    private String cityCode;

    private String sort;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
