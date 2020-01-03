package com.springboot.bcode.dao;

import java.util.List;

import com.springboot.bcode.domain.auth.UserInfo;
import com.springboot.bcode.domain.auth.UserRole;
import com.springboot.core.web.mvc.JqGridPage;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:32
 * @Package: com.springboot.bcode.dao
 */

public interface UserDao {

    JqGridPage<UserInfo> selectPage(UserInfo user);

    UserInfo find(UserInfo user);

    List<UserInfo> findList(UserInfo user);

    UserInfo select(String id);

    int insert(UserInfo user);

    int[] insert(List<UserRole> list);

    int update(UserInfo user);

    int updateState(String uid,int state);

    int delete(UserInfo user);

    int delete(UserRole userRelationRole);

}
