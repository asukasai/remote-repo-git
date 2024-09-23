package com.jiang.springboot_project.utils;

import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Data
@Component
@ConfigurationProperties(prefix = "jwt.token")
public class JwtHelper {
    private long tokenExpiration; // 有效时间, 单位为毫秒
    private String tokenSignKey;  // 当前程序签名秘钥

    // 生成token字符串
    public String createToken(Long userId) {
        System.out.println("tokenExpiration = " + tokenExpiration);
        System.out.println("tokenSignKey = " + tokenSignKey);
        String token = Jwts.builder()
                .setSubject("YYGH-USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration * 1000 * 60)) // 单位为分钟
                .claim("userId", userId)
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    // 从token字符串获取userId
    public Long getUserId(String token) {
        if (!StringUtils.hasText(token)) return null; // 使用 Spring 的 StringUtils
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        Integer userId = (Integer) claims.get("userId");
        return userId.longValue();
    }

    // 判断token是否有效
    public boolean isExpiration(String token) {
        try {
            boolean isExpire = Jwts.parser()
                    .setSigningKey(tokenSignKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration().before(new Date());
            // 没有过期，有效，返回false
            return isExpire;
        } catch (Exception e) {
            // 过期出现异常，返回true
            return true;
        }
    }
}
