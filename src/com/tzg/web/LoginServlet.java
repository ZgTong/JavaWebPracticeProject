package com.tzg.web;

import com.tzg.pojo.User;
import com.tzg.service.UserService;
import com.tzg.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(null,username,password,null));
        if (loginUser==null){
            req.getRequestDispatcher("/pages/user/login.html").forward(req,res);
        }else{
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req,res);
        }
    }
}
