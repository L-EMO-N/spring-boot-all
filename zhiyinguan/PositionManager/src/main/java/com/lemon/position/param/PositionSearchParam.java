package com.lemon.position.param;

import com.lemon.util.PageUtil;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author LEMON
 */
public class PositionSearchParam  extends PageUtil {


    private static final long serialVersionUID = 2296277193580843501L;

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

    @Override
    public String toString() {
        return "PositionSearchParam{" +
                "type=" + type +
                ", positionName='" + positionName + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
