package com.tzg.web;

import com.tzg.pojo.User;
import com.tzg.service.UserService;
import com.tzg.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService  = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if ("aaaaaa".equalsIgnoreCase(code)){
            //验证码正确
            if (userService.existsUsername(username)){
                //不可用
                System.out.println("用户名[" + username + "]已存在!");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req,res);
            }else{
                //可用
                userService.register(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,res);
            }

        }else{
            //验证码错误
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,res);
        }
    }

}
