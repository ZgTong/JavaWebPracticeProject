package com.tzg.web;

import com.tzg.pojo.User;
import com.tzg.service.UserService;
import com.tzg.service.impl.UserServiceImpl;
import com.tzg.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class UserServlet extends BaseServlet {
    private UserService userService  = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(null,username,password,null));
        if (loginUser==null){
            // 把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg","用户或密码错误！");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,res);
        }else{
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,res);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
        if ("aaaaaa".equalsIgnoreCase(code)){
            //验证码正确
            if (userService.existsUsername(username)){
                //不可用
                System.out.println("用户名[" + username + "]已存在!");
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,res);
            }else{
                //可用
                userService.register(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,res);
            }

        }else{
            //验证码错误
            System.out.println("验证码错误");
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,res);
        }
    }

}
