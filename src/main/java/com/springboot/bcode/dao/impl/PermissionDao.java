package com.springboot.bcode.dao;

import java.util.List;

import com.springboot.bcode.domain.auth.Permission;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:31
 * @Package: com.springboot.bcode.dao
 */

public interface PermissionDao {
    Permission select(Integer id);

    List<Permission> selectAll();

    List<Permission> selectByRole(Integer[] roleIds);

    List<Permission> find(Permission right);

    List<Permission> findChild(Integer parentCode);

    int insert(Permission right);

    int update(Permission right);

    int delete(Permission right);

}
