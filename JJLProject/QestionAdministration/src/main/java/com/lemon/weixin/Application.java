package com.lemon.weixin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by luolin on 2018/1/28.
 */
@SpringBootApplication
@MapperScan("com.lemon.weixin.*.dao")
public class Application extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class) ;
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        System.out.println("============启动成功======");
    }

}
