package zy.code.demo.parent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources(
        value = {
                @PropertySource(value = {"classpath:application.properties"}, encoding = "utf-8")
        })
@SpringBootApplication
@MapperScan("zy.code.demo.dao")
public class DemoParentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoParentApplication.class, args);
    }

}
