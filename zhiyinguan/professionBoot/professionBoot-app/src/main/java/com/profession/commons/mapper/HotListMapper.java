package com.profession.commons.mapper;

import com.profession.commons.beans.CommunityQueryCriteria;
import com.profession.commons.beans.HotList;
import com.profession.commons.beans.User;
import com.profession.commons.mybatis.CommonMapper;

import java.util.List;

/**
 * Created by dengjie0707 on 2018/7/3.
 */
public interface HotListMapper extends CommonMapper<User> {
    public List<HotList> queryHotList(CommunityQueryCriteria c);
}
