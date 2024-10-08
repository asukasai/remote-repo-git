package com.jiang.springboot_project.pojo;

/**
 * 统一返回结果状态信息类
 *
 * SUCCESS 成功
 * USERNAME_ERROR 用户名错误
 * PASSWORD_ERROR 密码错误
 * NOTLOGIN 未登录
 * USERNAME_USED 用户名重复
 */
public enum ResultCodeEnum {

    SUCCESS(200,"success"),
    USERNAME_ERROR(501,"usernameError"),
    PASSWORD_ERROR(503,"passwordError"),
    NOTLOGIN(504,"notLogin"),
    USERNAME_USED(505,"userNameUsed");

    private final Integer code;
    private final String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
