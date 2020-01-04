package com.springboot.bcode.service;

import java.util.List;

import com.springboot.bcode.domain.auth.Role;
import com.springboot.common.exception.AuthException;
import com.springboot.core.web.mvc.JqGridPage;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:04
 * @Package: com.springboot.bcode.service
 */

public interface RoleService {

    JqGridPage<Role> queryPage(Role role);

    List<Role> queryAll() throws AuthException;

    List<Role> queryByUser(String userId) throws AuthException;

    Role query(Integer code) throws AuthException;

    boolean add(Role role) throws AuthException;

    boolean update(Role role) throws AuthException;

    boolean delete(Integer code) throws AuthException;

    boolean saveRelationDataScope(Role role);

    List<Integer> queryDataScope(Integer roleId);

}
