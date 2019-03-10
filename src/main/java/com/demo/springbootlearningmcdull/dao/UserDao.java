package com.demo.springbootlearningmcdull.dao;

import com.demo.springbootlearningmcdull.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    int insert(User user);

    List<User> selectUsers();
}
