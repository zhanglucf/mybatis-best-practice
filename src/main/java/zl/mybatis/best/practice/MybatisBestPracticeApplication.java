package zl.mybatis.best.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "zl.mybatis.best.practice.mapper")
@SpringBootApplication
public class MybatisBestPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisBestPracticeApplication.class, args);
    }

}
