package com.profession.modules.community.service.impl;

import com.profession.commons.beans.CommunityQueryCriteria;
import com.profession.commons.beans.HotList;
import com.profession.commons.mapper.HotListMapper;
import com.profession.modules.community.service.interfaces.HotListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengjie0707 on 2018/7/1.
 */
@Service
public class HotListServiceImpl implements HotListService{
    @Autowired
    private HotListMapper hotListMapper;

    @Override
    public List<HotList> queryHotList(CommunityQueryCriteria c){
        List<HotList> list = new ArrayList<>();
        list =hotListMapper.queryHotList(c);
        return list;
    }
}
