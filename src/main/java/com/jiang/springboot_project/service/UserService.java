package com.jiang.springboot_project.service;

import com.jiang.springboot_project.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author JIANG
* @ description 针对表【news_user】的数据库操作Service
* @ createDate 2024-09-11 15:54:12
*/
public interface UserService extends IService<User> {
    List<User> getUserList();
}
