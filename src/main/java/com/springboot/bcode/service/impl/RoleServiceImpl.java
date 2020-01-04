package com.springboot.bcode.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bcode.dao.PermissionDao;
import com.springboot.bcode.dao.RoleDao;
import com.springboot.bcode.dao.UserDao;
import com.springboot.bcode.domain.auth.Role;
import com.springboot.bcode.domain.auth.RoleDept;
import com.springboot.bcode.domain.auth.RolePermission;
import com.springboot.bcode.service.RoleService;
import com.springboot.common.constant.DataScopeType;
import com.springboot.common.exception.AuthException;
import com.springboot.common.utils.BeanUtils;
import com.springboot.common.utils.StringUtils;
import com.springboot.core.web.mvc.JqGridPage;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:57
 * @Package: com.springboot.bcode.service.impl
 */

@SuppressWarnings("ALL")
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private PermissionDao rightDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public JqGridPage<Role> queryPage(Role role) {
        return roleDao.selectPage(role);
    }

    @Override
    public List<Role> queryAll() throws AuthException {
        return roleDao.select(new Role());
    }

    @Override
    public List<Role> queryByUser(String userId) throws AuthException {
        if (StringUtils.isBlank(userId)) {
            throw new AuthException("userId不能为空");
        }
        return roleDao.selectByUserId(userId);
    }

    @Transactional(value = "baseTransactionManager")
    @Override
    public boolean add(Role role) throws AuthException {
        if (role == null) {
            throw new AuthException("保存数据不能为空");
        }
        if (StringUtils.isBlank(role.getName())) {
            throw new AuthException("角色名不能为空");
        }
        int result = roleDao.insertRetrunId(role);

        if (role.getPermIds() != null && role.getPermIds().length > 0) {
            role.setId(result);
            saveRelationPermission(role);
        }
        return true;
    }

    @Transactional(value = "baseTransactionManager")
    @Override
    public boolean update(Role role) throws AuthException {

        if (role == null) {
            throw new AuthException("保存数据不能为空");
        }
        if (role.getId() == null) {
            throw new AuthException("保存数据不能为空");
        }
        if (StringUtils.isBlank(role.getName())) {
            throw new AuthException("角色名不能为空");
        }
        Role roleInfo = roleDao.select(role.getId());
        if (roleInfo == null) {
            throw new AuthException("未查询到角色信息");
        }
        BeanUtils.copyObject(roleInfo, role);
        roleDao.update(roleInfo);

        RolePermission rp = new RolePermission();
        rp.setRoleId(role.getId());
        roleDao.delete(rp);
        if (role.getPermIds() != null && role.getPermIds().length > 0) {
            saveRelationPermission(role);
        }
        return true;
    }

    public boolean saveRelationPermission(Role role) {
        List<RolePermission> rpList = new ArrayList<RolePermission>();
        RolePermission rp = null;
        for (int i = 0; i < role.getPermIds().length; i++) {
            rp = new RolePermission();
            rp.setRoleId(role.getId());
            rp.setPermId(role.getPermIds()[i]);
            rpList.add(rp);
        }
        roleDao.insert(rpList);
        return true;
    }

    @Transactional(value = "baseTransactionManager")
    @Override
    public boolean delete(Integer code) throws AuthException {
        if (code == null) {
            throw new AuthException("删除条件不能为空");
        }
        Role role = new Role();
        role.setId(code);
        int result = 0;
        // 删除角色本身
        result = roleDao.delete(role);
        if (result < 0) {
            throw new AuthException("执行失败");
        }

        // 删除角色对应的权限
        RolePermission roleRight = new RolePermission();
        roleRight.setRoleId(code);
        roleDao.delete(roleRight);

        return true;
    }

    @Override
    public Role query(Integer code) throws AuthException {

        Role role = new Role();
        role.setId(code);
        List<Role> list = roleDao.select(role);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Transactional(value = "baseTransactionManager")
    @Override
    public boolean saveRelationDataScope(Role role) {
        if (role == null) {
            throw new AuthException("条件不能为空");
        }
        if (role.getId() == null || role.getData_scope() == null) {
            throw new AuthException("条件不能为空");
        }
        Role roleInfo = roleDao.select(role.getId());
        if (roleInfo == null) {
            throw new AuthException("角色不存在");
        }

        // 自定义数据权限
        if (role.getData_scope().equals(DataScopeType.customize)) {
            if (role.getDeptIds() == null || role.getDeptIds().length == 0) {
                throw new AuthException("自定义数据权限不能为空");
            }
            RoleDept delRoleDept = new RoleDept();
            delRoleDept.setRoleId(role.getId());
            roleDao.deleteRoleDetp(delRoleDept);

            List<RoleDept> rdList = new ArrayList<RoleDept>();
            RoleDept rd = null;
            for (int i = 0; i < role.getDeptIds().length; i++) {
                rd = new RoleDept();
                rd.setRoleId(role.getId());
                rd.setDeptId(role.getDeptIds()[i]);
                rdList.add(rd);
            }
            roleDao.insertRoleDetp(rdList);
        }
        roleInfo.setData_scope(role.getData_scope());
        roleDao.update(roleInfo);
        return true;
    }

    @Override
    public List<Integer> queryDataScope(Integer roleId) {
        if (roleId == null) {
            throw new AuthException("条件不能为空");
        }
        return roleDao.selectRoleDetp(roleId);
    }
}
