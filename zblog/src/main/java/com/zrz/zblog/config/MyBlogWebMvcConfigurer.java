package com.zrz.zblog.config;

import com.zrz.zblog.interceptor.AdminLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Rongze Zhao
 * @date 2019-07-25 15:47
 */
@Configuration
public class MyBlogWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;

    /**
     * 添加管理操作拦截器
     * @author Rongze Zhao
     * @date 2019/7/25 15:49
     * @param
    */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器，拦截以/admin为前缀的url路径
        registry.addInterceptor(adminLoginInterceptor).
                addPathPatterns("/admin/**").
                excludePathPatterns("/admin/login").
                excludePathPatterns("/admin/dist/**").
                excludePathPatterns("/admin/plugins/**");
    }

    /**
     * 添加文件上传拦截器
     * @author Rongze Zhao
     * @date 2019/7/25 15:50
     * @param
    */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**");
    }

}
