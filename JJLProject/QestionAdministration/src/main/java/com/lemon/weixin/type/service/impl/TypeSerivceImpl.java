package com.lemon.weixin.type.service.impl;

import com.lemon.weixin.type.dao.TypeDao;
import com.lemon.weixin.type.entity.Type;
import com.lemon.weixin.type.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by luolin on 2018/1/30.
 */
@Service("TypeSerivce")
public class TypeSerivceImpl implements ITypeService {
    @Autowired
    private TypeDao typeDao;

    @Override
    public int insertType(Type type) {
        return typeDao.insertType(type);
    }

    @Override
    public int deleteTypeById(Long id) {
        return typeDao.deleteTypeById(id);
    }

    @Override
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Override
    public List<Type> getTypePage(Type type, int start, int end) {
        return typeDao.getTypePage(type,start,end);
    }

    @Override
    public int getCountByName(String name) {
        return typeDao.getCountByName(name);
    }

    @Override
    public Type getTypeById(Long id) {
        return typeDao.getTypeById(id);
    }

    @Override
    public Type getTypeByNameAndId(long id, String name) {
        return typeDao.getTypeByNameAndId(id,name);
    }
}
