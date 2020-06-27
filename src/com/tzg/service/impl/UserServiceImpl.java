package com.tzg.service.impl;

import com.tzg.dao.UserDao;
import com.tzg.dao.impl.UserDaoImpl;
import com.tzg.pojo.User;
import com.tzg.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void register(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username)==null){
            return false;
        }
        return true;
    }
}
