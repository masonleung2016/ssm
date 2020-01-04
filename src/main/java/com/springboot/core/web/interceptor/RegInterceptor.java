package com.springboot.core.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:50
 * @Package: com.springboot.core.web.interceptor
 */

@Configuration
public class RegInterceptor implements WebMvcConfigurer {
    @Autowired
    private AppContextInterceptor appContextInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(appContextInterceptor);
    }
}
