package com.lemon.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author LEMON
 * 此类配置 犹如web.xml
 */

public class DispatcherServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /** 
     *返回带有@Configuration的类来定义ContextLoaderListener
     * 创建非web注解配置的bean   如  service  resposity
     * 此配置 犹如web.xml中的 ContextLoaderListener
     *@author LEMON
    */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     *返回带有@Configuration的类来定义DispatcherServlet
     * 来定义上下文中的bean   如  controller
     *@author LEMON
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{Webconfig.class};
    }

    /**
     *请求路径映射
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
