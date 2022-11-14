package com.xxx.springboot.controller;

import com.xxx.springboot.po.User;
import com.xxx.springboot.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("user/{username}")
    public User queryUserByUserName(@PathVariable String username) {

        return userService.queryUserByUserName(username);
    }
}
