package com.demo.springbootlearningmcdull.service;

import com.demo.springbootlearningmcdull.dao.UserDao;
import com.demo.springbootlearningmcdull.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public List<User> selectUsers() {
        return userDao.selectUsers();
    }
}
