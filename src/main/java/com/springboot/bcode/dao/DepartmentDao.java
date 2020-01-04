package com.springboot.bcode.dao;

import java.util.List;

import com.springboot.bcode.domain.auth.Department;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:27
 * @Package: com.springboot.bcode.dao
 */

public interface DepartmentDao {

    Department selectOne(Integer id);

    List<Department> findChild(Integer parentId);

    List<Department> selectAll();

    int insert(Department dept);

    int update(Department dept);

    int delete(Department dept);

}
