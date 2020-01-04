package com.springboot.core.redis;

import org.springframework.stereotype.Component;

import com.springboot.core.web.SpringUtils;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:44
 * @Package: com.springboot.core.redis
 */

@Component
public class RedisUtils {
    // cache
    private static volatile IRedis redis = null;

    public static IRedis getRedis() {
        if (redis == null) {
            redis = SpringUtils.getBean(IRedis.class);
            ;
        }
        return redis;
    }

}
