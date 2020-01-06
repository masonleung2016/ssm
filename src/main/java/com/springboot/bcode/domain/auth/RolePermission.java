package com.springboot.bcode.domain.auth;

import com.springboot.core.jdbc.annotation.Columns;
import com.springboot.core.jdbc.annotation.Tables;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:47
 * @Package: com.springboot.bcode.domain.auth
 */

@Tables(table = "t_web_role_permission")
public class RolePermission {

    @Columns(column = "role_id")
    private Integer roleId;
    
    @Columns(column = "perm_id")
    private Integer permId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }
}
