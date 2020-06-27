package com.tzg.test;

import com.tzg.pojo.User;
import com.tzg.service.UserService;
import com.tzg.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void register() {
        userService.register(new User(null,"ll123","111111","ll123@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "ll123", "111111", "ll123@qq.com")));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("admin")){
            System.out.println("用户名已存在");
        }else {
            System.out.println("用户名可用！");
        }
    }
}