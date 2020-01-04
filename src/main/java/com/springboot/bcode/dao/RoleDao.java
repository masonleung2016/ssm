package com.springboot.bcode.dao;

import java.util.List;

import com.springboot.bcode.domain.auth.Role;
import com.springboot.bcode.domain.auth.RoleDept;
import com.springboot.bcode.domain.auth.RolePermission;
import com.springboot.core.web.mvc.JqGridPage;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:31
 * @Package: com.springboot.bcode.dao
 */

public interface RoleDao {
    JqGridPage<Role> selectPage(Role role);

    List<Role> selectByUserId(String userId);

    Role select(Integer id);

    List<Role> select(Role role);

    int insertRetrunId(Role role);

    int insert(Role role);

    int update(Role role);

    int delete(Role role);

    int[] insert(List<RolePermission> rpList);

    int delete(RolePermission roleRelationRight);

    int[] insertRoleDetp(List<RoleDept> list);

    int deleteRoleDetp(RoleDept roleDept);

    List<Integer> selectRoleDetp(Integer roleId);

}
