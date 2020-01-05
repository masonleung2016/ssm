package com.springboot.bcode.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bcode.dao.RoleDao;
import com.springboot.bcode.domain.auth.Role;
import com.springboot.bcode.domain.auth.RoleDept;
import com.springboot.bcode.domain.auth.RolePermission;
import com.springboot.common.utils.StringUtils;
import com.springboot.core.jdbc.BaseDaoImpl;
import com.springboot.core.web.mvc.JqGridPage;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:23
 * @Package: com.springboot.bcode.dao.impl
 */

@Repository
public class RoleDaoImpl extends BaseDaoImpl implements RoleDao {
    @Override
    public JqGridPage<Role> selectPage(Role role) {
        List<Role> list = super.select(
                getSqlPageHandle().handlerPagingSQL(rolePageSql(role, 0),
                        role.getPage(), role.getLimit()), null, Role.class);
        int count = super.jdbcTemplate.queryForObject(rolePageSql(role, 1),
                null, Integer.class);
        JqGridPage<Role> page = new JqGridPage<Role>(list, count,
                role.getLimit(), role.getPage());
        return page;
    }

    private String rolePageSql(Role role, int type) {
        StringBuilder sql = new StringBuilder();
        if (type == 0) {
            sql.append("select * from t_web_role");
        } else {
            sql.append("select count(*) from t_web_role");
        }
        sql.append(" where 1=1");

        if (StringUtils.isNotBlank(role.getName())) {
            sql.append(" and name like '%").append(
                    role.getName().trim() + "%' ");
        }
        if (type == 0) {
            if (StringUtils.isNotBlank(role.getSidx())) {
                if (("asc".equalsIgnoreCase(role.getSord().trim()))) {
                    sql.append(" order by " + role.getSidx().split(" ")[0]
                            + " asc");
                } else {
                    sql.append(" order by " + role.getSidx().split(" ")[0]
                            + " desc");
                }
            } else {
                sql.append(" order by id asc");
            }
        }
        return sql.toString();
    }

    @Override
    public List<Role> selectByUserId(String userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT r.id,r.name,r.data_scope from t_web_user_role ur INNER JOIN t_web_role r on ur.role_id=r.id ");
        sql.append(" where  ur.user_id=? ");

        return super
                .select(sql.toString(), new Object[] { userId }, Role.class);
    }

    @Override
    public List<Role> select(Role role) {
        return super.select(role);
    }

    @Override
    public int insert(Role role) {
        return super.insert(role);
    }

    @Override
    public int insertRetrunId(Role role) {
        return super.insertReturnAutoIncrement(role);
    }

    @Override
    public int update(Role role) {
        return super.update(role);
    }

    @Override
    public int delete(Role role) {
        return super.delete(role);
    }

    @Override
    public int[] insert(List<RolePermission> rpList) {
        return super.batchInsert(rpList);
    }

    @Override
    public int delete(RolePermission roleRelationRight) {
        return super.delete(roleRelationRight);
    }

    @Override
    public Role select(Integer id) {
        return super.selectById(id, Role.class);
    }

    @Override
    public int[] insertRoleDetp(List<RoleDept> list) {
        return super.batchInsert(list);
    }

    @Override
    public int deleteRoleDetp(RoleDept roleDept) {
        return super.delete(roleDept);
    }

    @Override
    public List<Integer> selectRoleDetp(Integer roleId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT dept_id from  t_web_role_dept  ");
        sql.append(" where  role_id=" + roleId + " ");
        return super.getJdbcTemplate().queryForList(sql.toString(),
                Integer.class);
    }

}
