package com.springboot.core.file;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:16
 * @Package: com.springboot.core.file
 */

@Configuration
public class MultipartConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个文件最大
        factory.setMaxFileSize(DataSize.of(100, DataUnit.MEGABYTES));
        // 100MB
        // / 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.of(100, DataUnit.MEGABYTES));
        // 100MB
        return factory.createMultipartConfig();
    }
}
