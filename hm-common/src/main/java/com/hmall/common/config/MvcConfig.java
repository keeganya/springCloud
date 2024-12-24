package com.hmall.common.config;

import com.hmall.common.interceptor.UserInfoInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author xiaohu
 * @Date 2024/12/3 15:09
 * @PackageName:com.hmall.common.config
 * @ClassName: MvcConfig
 * @Description: TODO
 * @Version 1.0
 */
@Configuration
/**
 * WebMvcConfigurer 是基于springMVC的,gateway包中没有引入springMVC，
 * 虽然引入了common包中有springMVC，但是其scope为private
 * @ConditionalOnClass(DispatcherServlet.class) 保证只有在有springMVC的模块下才能生效该配置类
* */
@ConditionalOnClass(DispatcherServlet.class)
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInfoInterceptor());
    }
}
