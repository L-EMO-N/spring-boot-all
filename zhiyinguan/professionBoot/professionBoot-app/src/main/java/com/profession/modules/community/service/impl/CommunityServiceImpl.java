package com.profession.modules.community.service.impl;

import com.profession.commons.beans.User;
import com.profession.commons.mapper.UserMapper;
import com.profession.modules.community.service.interfaces.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dengjie0707 on 2018/7/1.
 */
@Service
public class CommunityServiceImpl implements CommunityService {


    @Autowired
    private UserMapper userMapper;
    @Override
    public List findHotList(String name) {
        List<User> users = userMapper.select(new User().withUserName(name));
        return Arrays.asList(users);
    }
}
