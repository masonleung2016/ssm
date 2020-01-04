package com.springboot.bcode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bcode.dao.DictDao;
import com.springboot.bcode.domain.auth.Dict;
import com.springboot.bcode.service.DictService;
import com.springboot.common.exception.SystemException;
import com.springboot.common.utils.BeanUtils;
import com.springboot.common.utils.StringUtils;
import com.springboot.core.web.mvc.JqGridPage;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:55
 * @Package: com.springboot.bcode.service.impl
 */

@SuppressWarnings("ALL")
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictDao dictDao;

    @Override
    public JqGridPage<Dict> queryPage(Dict dict) {
        return dictDao.selectPage(dict);
    }

    @Override
    public List<Dict> queryByType(String type) {
        if (StringUtils.isBlank(type)) {
            return null;
        }
        Dict dict = new Dict();
        dict.setData_type(type);
        return dictDao.select(dict);
    }

    @Override
    public boolean add(Dict dict) {
        if (dict == null) {
            throw new SystemException("保存数据不能为空");
        }
        if (StringUtils.isBlank(dict.getData_type())) {
            throw new SystemException("Type不能为空");
        }
        if (StringUtils.isBlank(dict.getData_key())) {
            throw new SystemException("Key不能为空");
        }
        if (StringUtils.isBlank(dict.getData_value())) {
            throw new SystemException("Value不能为空");
        }
        int result = dictDao.insert(dict);
        if (result <= 0) {
            throw new SystemException("执行失败");
        }
        return true;
    }

    @Override
    public boolean update(Dict dict) {
        if (dict == null) {
            throw new SystemException("保存数据不能为空");
        }
        if (dict.getId() == null) {
            throw new SystemException("保存数据不能为空");
        }
        if (StringUtils.isBlank(dict.getData_type())) {
            throw new SystemException("Type不能为空");
        }
        if (StringUtils.isBlank(dict.getData_key())) {
            throw new SystemException("Key不能为空");
        }
        if (StringUtils.isBlank(dict.getData_value())) {
            throw new SystemException("Value不能为空");
        }

        Dict dictInfo = dictDao.select(dict.getId());
        if (dictInfo == null) {
            throw new SystemException("未查询到字典信息");
        }
        BeanUtils.copyObject(dictInfo, dict);
        int result = dictDao.update(dictInfo);
        if (result < 0) {
            throw new SystemException("执行失败");
        }
        return true;
    }

    @Override
    public boolean delete(Integer id) throws SystemException {
        if (id == null) {
            throw new SystemException("删除条件不能为空");
        }
        Dict dict = new Dict();
        dict.setId(id);
        // 删除角色本身
        int result = dictDao.delete(dict);
        if (result < 0) {
            throw new SystemException("执行失败");
        }

        return true;
    }

}
