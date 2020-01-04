package com.springboot.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.common.AppContext;
import com.springboot.core.web.mvc.ResponseResult;

/**
 * 全局异常
 *
 * @Author: LCF
 * @Date: 2020/1/2 17:11
 * @Package: com.springboot.common.exception
 */

@ControllerAdvice
class GlobalExceptionHandler {

    // json exceptin
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult jsonErrorHandler(HttpServletRequest req, Exception e)
            throws Exception {
        ResponseResult r = new ResponseResult();
        r.setCode(AppContext.CODE_50000);
        r.setMsg("系统异常");
        return r;
    }
}
