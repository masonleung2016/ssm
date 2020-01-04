package com.springboot.bcode.service;

import com.springboot.bcode.domain.logs.BLog;
import com.springboot.bcode.domain.logs.BLogVO;
import com.springboot.core.web.mvc.JqGridPage;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:03
 * @Package: com.springboot.bcode.service
 */

public interface LogService {

    JqGridPage<BLog> queryPage(BLogVO vo);
}
