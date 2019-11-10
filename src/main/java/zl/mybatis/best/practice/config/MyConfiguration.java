package zl.mybatis.best.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import zl.mybatis.best.practice.support.RespondResultInterceptor;
//@EnableWebMvc
@Configuration
public class MyConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(new RespondResultInterceptor());
        //指定拦截匹配模式，限制拦截器拦截请求
//        ir.addPathPatterns("/*");
    }
}
