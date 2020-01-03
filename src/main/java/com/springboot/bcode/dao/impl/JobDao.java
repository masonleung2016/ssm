package com.springboot.bcode.dao;

import java.util.List;

import com.springboot.bcode.domain.auth.Job;
import com.springboot.core.web.mvc.JqGridPage;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:30
 * @Package: com.springboot.bcode.dao
 */

public interface JobDao {

    JqGridPage<Job> selectPage(Job job);

    List<Job> selectAll();

    Job selectOne(Job job);

    Job selectOne(Integer id);

    int insert(Job job);

    int update(Job job);

    int updateState(Integer id, int state);

    int delete(Job job);

}
