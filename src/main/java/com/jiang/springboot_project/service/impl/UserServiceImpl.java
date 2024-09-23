package com.jiang.springboot_project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiang.springboot_project.pojo.User;
import com.jiang.springboot_project.service.UserService;
import com.jiang.springboot_project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author JIANG
* @ description 针对表【news_user】的数据库操作Service实现
* @ createDate 2024-09-11 15:54:12
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        List<User> users = userMapper.selectList(null);
        return users;
    }
}




