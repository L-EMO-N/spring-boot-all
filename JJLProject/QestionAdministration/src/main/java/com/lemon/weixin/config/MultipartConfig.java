package com.lemon.weixin.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/8/13
 */
@Configuration
public class MultipartConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement(){

        MultipartConfigFactory factory = new MultipartConfigFactory();
        long singleMaxSize = 1024 * 20;
        long totalMaxSize = 1024 * 20;
        //单个文件最大
        factory.setMaxFileSize(singleMaxSize + "KB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(totalMaxSize + "KB");
        return factory.createMultipartConfig();
    }
}
