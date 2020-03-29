package com.springbook.biz.user.service;

import com.springbook.biz.user.command.UserVO;
import com.springbook.biz.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    // Setter Injection용.
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserVO getUser(UserVO user) {
        return userDAO.getUser(user);
    }
}
