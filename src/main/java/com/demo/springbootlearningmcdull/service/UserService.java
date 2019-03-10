package com.demo.springbootlearningmcdull.service;

import com.demo.springbootlearningmcdull.entity.User;

import java.util.List;

public interface UserService {
    int insert(User user);

    List<User> selectUsers();
}
