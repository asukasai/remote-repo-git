package com.jiang.springboot_project.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jiang.springboot_project.mapper.UserMapper;
import com.jiang.springboot_project.pojo.LoginUser;
import com.jiang.springboot_project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DbDetailsServiceManager implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(username);
        }
        //
        return new LoginUser(user);
    }
}
