package zy.code.demo.parent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("zy.code.demo.dao")
public class DemoParentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoParentApplication.class, args);
    }

}
