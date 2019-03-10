package com.demo.springbootlearningmcdull.controller;

import com.demo.springbootlearningmcdull.entity.User;
import com.demo.springbootlearningmcdull.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 查询方法测试：PostMan中输入：http://localhost:8080/user，发送GET请求
 * 插数据方法测试：PostMan中输入：http://localhost:8080/user?id=3&name=hhh，发送POST请求
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity addUser(
            @RequestParam(value = "id", required=true)int id,
            @RequestParam(value = "name", required=true)String name
    ){
        User user = new User();
        user.setId(id);
        user.setName(name);
        userService.insert(user);
        return ResponseEntity.ok("添加成功");
    }

    @GetMapping("")
    public ResponseEntity getUsers(){
        return ResponseEntity.ok(userService.selectUsers());
    }
}
