package com.springboot.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.springboot.bcode.domain.auth.UserInfo;
import com.springboot.core.redis.RedisUtils;
import com.springboot.core.web.session.CookieContext;
import com.sun.deploy.net.HttpUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:15
 * @Package: com.springboot.common.utils
 */

public class GlobalUser {

    public final static Integer USER_ENABLE = 1;
    // 正常

    public final static Integer USER_UNABLE = 0;
    // 禁用

    private static final String USER_INFO = "user_info_";

    public static void setUserInfo(UserInfo userInfo) {
        if (userInfo == null) {
            return;
        }
        RedisUtils.getRedis().set(USER_INFO + "" + userInfo.getToken(),
                JSONObject.toJSONString(userInfo), 90, TimeUnit.DAYS);
    }


    public static UserInfo getUserInfo() {
        String token = getToken();
        if (StringUtils.isBlank(token)) {
            return null;
        }
        UserInfo userInfo = null;
        String str = RedisUtils.getRedis().get(USER_INFO + "" + token);
        if (StringUtils.isBlank(str)) {
            return null;
        }
        userInfo = JSONObject.parseObject(str, UserInfo.class);

        return userInfo;
    }

    public static void destroyUser() {
        RedisUtils.getRedis().delete(USER_INFO + "" + getToken());
    }

    public static String getToken() {
        String token = HttpUtils.getRequest().getHeader(AppContext.TOKEN);
        if (StringUtils.isBlank(token)) {
            token = CookieContext.get(AppContext.TOKEN);
        }
        return token;
    }

}
