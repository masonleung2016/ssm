package com.springboot.bcode.domain.auth;

import com.springboot.core.jdbc.annotation.Columns;
import com.springboot.core.jdbc.annotation.Tables;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:50
 * @Package: com.springboot.bcode.domain.auth
 */

@Tables(table = "t_web_user_role")
public class UserRole {
    @Columns(column = "user_id")
    private String userId;
    
    @Columns(column = "role_id")
    private Integer roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
