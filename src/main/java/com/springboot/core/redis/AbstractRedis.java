package com.springboot.core.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:42
 * @Package: com.springboot.core.redis.config
 */

public abstract class AbstractRedis implements IRedis {

    @Autowired
    protected StringRedisTemplate stringRedisTemplate;

}
