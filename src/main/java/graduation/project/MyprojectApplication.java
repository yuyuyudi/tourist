package graduation.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "graduation.project.mapper")
public class MyprojectApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MyprojectApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        构建新资源
        return builder.sources(MyprojectApplication.class);
    }
}
