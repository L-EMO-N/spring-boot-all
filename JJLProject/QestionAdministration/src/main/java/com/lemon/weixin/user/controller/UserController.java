package com.lemon.weixin.user.controller;

import com.lemon.weixin.user.entity.User;
import com.lemon.weixin.user.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luolin on 2018/1/28.
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping("/getUserById")
    public User getUserByid(long id){
        return userService.getUserById(id);
    }

    @RequestMapping("/saveUser")
    public int saveUser(User user){
//        User user = new User();
        user.setPassword("123456");
        user.setUsername("admin");
        user.setPhone("13888888888");
        return userService.saveUser(user);
    }

    @RequestMapping("/login")
    public String login(String username,String password){
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
                    return "用户名或密码不正确";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User loginUser = userService.loginUser(user);
        if( user == null){
            return "用户名或密码不正确";
        }
        return "success";
    }
}
