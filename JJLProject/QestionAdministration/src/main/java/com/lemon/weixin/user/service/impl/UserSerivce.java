package com.lemon.weixin.user.service.impl;

import com.lemon.weixin.user.dao.UserDao;
import com.lemon.weixin.user.entity.User;
import com.lemon.weixin.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by luolin on 2018/1/28.
 */
@Service
public class UserSerivce implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    /**
     * 保存user
     *
     * @param user
     */
    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public int deleteUserByid(long id) {
        return 0;
    }

    /**
     * 更新User
     *
     * @param user
     * @return
     */
    @Override
    public int updaetUser(User user) {
        return 0;
    }

    @Override
    public User loginUser(User user) {
        return userDao.loginUser(user);
    }

    @Override
    public int countByUsername(String username) {
        return 0;
    }
}
