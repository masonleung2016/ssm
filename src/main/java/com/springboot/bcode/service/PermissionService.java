package com.springboot.bcode.service;

import java.util.List;

import com.springboot.bcode.domain.auth.Permission;
import com.springboot.common.exception.AuthException;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:04
 * @Package: com.springboot.bcode.service
 */

public interface PermissionService {

    List<Permission> queryAll();

    List<Permission> queryByRole(Integer[] roleIds);

    Permission query(Integer code) throws AuthException;

    boolean add(Permission right) throws AuthException;

    boolean update(Permission right) throws AuthException;

    boolean delete(Integer code) throws AuthException;

}
