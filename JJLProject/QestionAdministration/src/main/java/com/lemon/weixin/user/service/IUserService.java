package com.lemon.weixin.user.service;

import com.lemon.weixin.user.entity.User;

/**
 * Created by luolin on 2018/1/28.
 */
public interface IUserService {

    /**
     * 根据id查询user
     */
    public User getUserById(long id);


    /**
     *  保存user
     */
    public int  saveUser(User user);


    /**
     *根据id删除User
     * @param id
     * @return
     */
    public int deleteUserByid(long id);


    /**
     * 更新User
     * @param user
     * @return
     */
    public int updaetUser(User user);


    public User loginUser(User user);


    public int countByUsername(String username);




}
