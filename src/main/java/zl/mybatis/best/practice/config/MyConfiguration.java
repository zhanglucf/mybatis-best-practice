package zl.mybatis.best.practice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import zl.mybatis.best.practice.support.RespondResultInterceptor;

//@EnableWebMvc
@Configuration
public class MyConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        registry.addInterceptor(new RespondResultInterceptor());
    }


}
