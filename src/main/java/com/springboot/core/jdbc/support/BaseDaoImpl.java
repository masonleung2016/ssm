package com.springboot.core.jdbc.support;

import com.springboot.bcode.domain.auth.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springboot.core.jdbc.page.ISQLPageHandle;

import java.util.List;


/**
 * @Author: LCF
 * @Date: 2020/1/2 17:34
 * @Package: com.springboot.core.jdbc.support
 */

public class BaseDaoImpl extends AbstractJdbcSupport {
    @Autowired
    @Qualifier("baseJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    /**
     * 分页处理
     */
    @Autowired
    @Qualifier("mysqlSQLPageHandle")
    protected ISQLPageHandle mysqlSQLPageHandle;

    @Override
    protected JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    protected ISQLPageHandle getSqlPageHandle() {
        return mysqlSQLPageHandle;
    }

    protected List<Department> select(String sql, Object[] objects, Class<Department> departmentClass) {
    }

    protected Department selectById(Integer id, Class<Department> departmentClass) {
    }

    protected int insert(Department dept) {
    }

    protected int update(Department dept) {
    }

    protected int delete(Department dept) {
    }
}
