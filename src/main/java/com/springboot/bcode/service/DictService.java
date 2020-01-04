package com.springboot.bcode.service;

import java.util.List;

import com.springboot.bcode.domain.auth.Dict;
import com.springboot.core.web.mvc.JqGridPage;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:02
 * @Package: com.springboot.bcode.service
 */

public interface DictService {

    JqGridPage<Dict> queryPage(Dict dict);

    List<Dict> queryByType(String type);

    boolean add(Dict dict);

    boolean update(Dict dict);

    boolean delete(Integer id);

}
