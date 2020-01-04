package com.springboot.core.web.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springboot.common.utils.AppContext;
import com.springboot.common.utils.GlobalUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.bcode.domain.auth.UserInfo;

/**
 * 拦截器，优先执行，验证用户是否登录
 *
 * @Author: LCF
 * @Date: 2020/1/2 17:50
 * @Package: com.springboot.core.web.interceptor
 */

@Component
public class AppContextInterceptor implements HandlerInterceptor {
    static List<String> permitUrl = new ArrayList<String>();
    static {
        permitUrl.add("/rest/user/login");
        permitUrl.add("/public/rest/");
        permitUrl.add("/index.html");
        permitUrl.add("/static");
        permitUrl.add("/favicon.ico");
    }

    private boolean permitAll(String requestURL) {
        for (String url : permitUrl) {
            if (requestURL.startsWith(url) || "/".equals(requestURL)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        String requestURL = request.getRequestURI();
        if (permitAll(requestURL)) {
            return true;
        }

        String token = GlobalUser.getToken();
        if (StringUtils.isBlank(token)) {
            returnNoLogin(request, response);
            return false;
        }

        UserInfo userInfo = GlobalUser.getUserInfo();
        if (userInfo == null) {
            returnNoLogin(request, response);
            return false;
        }
        return true;
    }

    private void returnNoLogin(HttpServletRequest request,
                               HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        out.println("{\"code\":" + AppContext.CODE_50001
                + ", \"msg\":\"Please login first!\"}");
        out.flush();
        out.close();
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exception)
            throws Exception {
    }
}
