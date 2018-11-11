package com.lemon.weixin.type.service;

import com.lemon.weixin.type.entity.Type;

import java.util.List;

/**
 * Created by luolin on 2018/1/30.
 */
public interface ITypeService {


    public int insertType(Type type);

    public int deleteTypeById(Long id);

    public int updateType(Type type);

    public List<Type> getTypePage(Type type,int start,int end);

    public int getCountByName(String name);

    public Type getTypeById(Long id);

    public Type getTypeByNameAndId(long id,String name);
}
