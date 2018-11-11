package com.lemon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author LEMON
 */
@Configuration
@EnableWebMvc  // 启用springMVC
@ComponentScan("com.lemon.*.controller")
public class Webconfig  extends WebMvcConfigurerAdapter {



    /** 
     *配置视图解析器
     *@author LEMON
    */
    @Bean
    public ViewResolver viewResolver(){

        InternalResourceViewResolver resolver   = new InternalResourceViewResolver();
         resolver.setPrefix("/WEB-INF/views/");
         resolver.setSuffix(".jsp");
        return  resolver;

    }

    /**
     * 没有此配置  DispatcherServlet会映射为应用的默认Servelet，
     * 所以它会处理所有请求，包括静态资源的请求，如图片 和 样式之类的
     *@author LEMON
    */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
