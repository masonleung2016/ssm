package com.springboot.bcode.service;

import java.util.List;

import com.springboot.bcode.domain.auth.Job;
import com.springboot.core.web.mvc.JqGridPage;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:02
 * @Package: com.springboot.bcode.service
 */

public interface JobService {

    JqGridPage<Job> queryPage(Job job);

    List<Job> queryAll();

    Job find(Integer id);

    Job find(Job job);

    boolean add(Job job);

    boolean update(Job job);

    boolean delete(Integer id);

    boolean updateState(Job job);

}
