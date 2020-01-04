package com.springboot.bcode.domain.auth;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:41
 * @Package: com.springboot.bcode.domain.auth
 */

public class LoginVO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
