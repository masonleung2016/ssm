package com.springboot.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置
 *
 * @Author: LCF
 * @Date: 2020/1/2 17:49
 * @Package: com.springboot.core.security
 */

@Configuration
public class CrossConfig {

    @Bean
    public CorsConfiguration corsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //实际请求中允许携带的首部字段
        corsConfiguration.addAllowedHeader("*");
        //允许那些域跨域访问
        corsConfiguration.addAllowedOrigin("*");
        //允许那些请求方法
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter(CorsConfiguration corsConfiguration) {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        // 4
        return new CorsFilter(source);
    }

}
