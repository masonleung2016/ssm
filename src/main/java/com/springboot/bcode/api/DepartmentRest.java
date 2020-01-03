package com.springboot.bcode.api;

import com.springboot.bcode.domain.auth.Department;
import com.springboot.bcode.service.DepartmentService;
import com.springboot.common.algorithm.DepartmentAlgorithm;
import com.springboot.common.exception.AuthException;
import com.springboot.core.logger.OpertionBLog;
import com.springboot.core.security.authorize.Requestauthorize;
import com.springboot.core.web.mvc.BaseRest;
import com.springboot.core.web.mvc.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 部门接口
 *
 * @Author: LCF
 * @Date: 2020/1/2 16:03
 * @Package: com.springboot.bcode.api
 */

@RestController
@RequestMapping(value = "/rest/department")
public class DepartmentRest extends BaseRest {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询所有部门
     *
     * @return
     */
    @Requestauthorize
    @RequestMapping(value = "all")
    public ResponseResult queryAll() {
        ResponseResult rep = new ResponseResult();
        try {
            rep.setResult(DepartmentAlgorithm.tree(departmentService.queryAll()));
        } catch (AuthException e) {
            rep.setCode(CODE_500);
            rep.setMsg(e.getMessage());
        } catch (Exception e) {
            rep.setCode(CODE_500);
            rep.setMsg("系统异常.请稍后再试");
        }
        return rep;
    }

    /**
     * 保存部门
     *
     * @param dept
     * @return
     */
    @Requestauthorize
    @OpertionBLog(title = "新增部门")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody Department dept) {
        ResponseResult rep = new ResponseResult();
        try {
            departmentService.add(dept);
        } catch (AuthException e) {
            rep.setCode(CODE_500);
            rep.setMsg(e.getMessage());
        } catch (Exception e) {
            rep.setCode(CODE_500);
            rep.setMsg("系统异常.请稍后再试");
        }

        return rep;
    }

    /**
     * 修改
     *
     * @param dept
     * @return
     */
    @Requestauthorize
    @OpertionBLog(title = "修改部门")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseResult update(@RequestBody Department dept) {
        ResponseResult rep = new ResponseResult();
        try {
            departmentService.update(dept);
        } catch (AuthException e) {
            rep.setCode(CODE_500);
            rep.setMsg(e.getMessage());
        } catch (Exception e) {
            rep.setCode(CODE_500);
            rep.setMsg("系统异常.请稍后再试");
        }
        return rep;
    }

    /**
     * 移除
     *
     * @param id
     * @return
     */
    @Requestauthorize
    @OpertionBLog(title = "删除部门")
    @RequestMapping(value = "delete")
    public ResponseResult delete(@RequestParam("id") Integer id) {
        ResponseResult rep = new ResponseResult();
        try {
            departmentService.delete(id);
        } catch (AuthException e) {
            rep.setCode(CODE_500);
            rep.setMsg(e.getMessage());
        } catch (Exception e) {
            rep.setCode(CODE_500);
            rep.setMsg("系统异常.请稍后再试");
        }
        return rep;
    }
}

