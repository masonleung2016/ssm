package com.springboot.bcode.service;

import java.util.List;

import com.springboot.bcode.domain.auth.Department;

/**
 * 查询部门信息
 *
 * @Author: LCF
 * @Date: 2020/1/2 17:00
 * @Package: com.springboot.bcode.service.impl
 */

public interface DepartmentService {
    List<Department> queryAll();

    Department query(Integer id);

    boolean add(Department dept);

    boolean update(Department dept);

    boolean delete(Integer id);
}
