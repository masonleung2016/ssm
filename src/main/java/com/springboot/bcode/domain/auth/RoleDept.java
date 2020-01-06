package com.springboot.bcode.domain.auth;

import com.springboot.core.jdbc.annotation.Columns;
import com.springboot.core.jdbc.annotation.Tables;

/**
 * 数据权限表
 *
 * @Author: LCF
 * @Date: 2020/1/2 16:45
 * @Package: com.springboot.bcode.domain.auth
 */

@Tables(table = "t_web_role_dept")
public class RoleDept {

    @Columns(column = "role_id")
    private Integer roleId;
    
    @Columns(column = "dept_id")
    private Integer deptId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
