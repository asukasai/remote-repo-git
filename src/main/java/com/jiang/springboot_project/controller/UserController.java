package com.jiang.springboot_project.controller;

import com.jiang.springboot_project.pojo.User;
import com.jiang.springboot_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("list")
    public List<User> selectAllUsers(){
        return userService.getUserList();
    }
}
