package com.springboot.bcode.dao.impl;

import java.util.List;
import com.springboot.bcode.dao.DepartmentDao;
import com.springboot.core.jdbc.support.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import com.springboot.bcode.domain.auth.Department;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:19
 * @Package: com.springboot.bcode.dao.impl
 */

@Repository
public class DepartmentDaoImpl extends BaseDaoImpl implements DepartmentDao {

    @Override
    public List<Department> selectAll() {
        String sql = "SELECT id,name,  parent_id as parentId,levels,for_service as forService,sorts from t_web_dept r where deleted=0  order by sorts asc ";
        Object parentId = new Object();
        return super.select(sql, new Object[]{parentId}, Department.class);
    }

    @Override
    public Department selectOne(Integer id) {
        return super.selectById(id, Department.class);
    }

    @Override
    public List<Department> findChild(Integer parentId) {
        String sql = "SELECT id,name,  parent_id as parentId,levels,for_service as forService,sorts,(SELECT top 1 tmp1.name  FROM t_web_dept as tmp1 WHERE tmp1.parent_id=r.id )  as tmpChildName from t_web_dept r where r.parent_id=? order by sorts asc ";
        return super.select(sql, new Object[] { parentId }, Department.class);
    }

    @Override
    public int insert(Department dept) {
        return super.insert(dept);
    }

    @Override
    public int update(Department dept) {
        return super.update(dept);
    }

    @Override
    public int delete(Department dept) {
        return super.delete(dept);
    }
}
