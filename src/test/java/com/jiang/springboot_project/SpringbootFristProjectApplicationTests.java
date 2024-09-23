package com.jiang.springboot_project;

import com.jiang.springboot_project.utils.JwtHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SpringbootFirstProjectApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private JwtHelper jwtHelper;

    @Test
    void contextLoads() {

    }

    @Test
    void securityPwdTest(){
        //加密
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);// $2a$10$kh4pvGjYDgJizGvDblEAnuESYgX7gdjV4IWWAPLmWeEamxJ6jRMuC

        //对比密文与明文是否一致 第一个参数为明文 第二个参数为密文
        boolean matches = passwordEncoder.matches("123456", "$2a$10$kh4pvGjYDgJizGvDblEAnuESYgX7gdjV4IWWAPLmWeEamxJ6jRMuC");
        System.out.println(matches);
    }

    @Test
    void jwtTest(){
        //生成 传入用户标识
        String token = jwtHelper.createToken(1L);
        System.out.println("token = " + token);

        //解析用户标识
        int userId = jwtHelper.getUserId(token).intValue();
        System.out.println("userId = " + userId);

        //校验是否到期! false 未到期 true到期
        boolean expiration = jwtHelper.isExpiration(token);
        System.out.println("expiration = " + expiration);
    }
}
