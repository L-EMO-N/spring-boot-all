package com.lemon.position.dto;

import com.lemon.util.BaseReps;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 */
public class PositionReps<T> extends BaseReps{

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
