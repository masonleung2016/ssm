package com.springboot.bcode.dao;

import com.springboot.bcode.domain.logs.BLog;
import com.springboot.bcode.domain.logs.BLogVO;
import com.springboot.core.web.mvc.JqGridPage;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:30
 * @Package: com.springboot.bcode.dao
 */

public interface LogDao {

    JqGridPage<BLog> selectPage(BLogVO  log);

    int insert(BLog log);

}
