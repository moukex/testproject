package com.boss.xtrain.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;
@EnableSwagger2
@MapperScan(value = "com.boss.xtrain.system.center.dao.mapper")
@SpringBootApplication(scanBasePackages = "com.boss.xtrain.system")
public class BossXtrainSystemControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BossXtrainSystemControllerApplication.class, args);
    }
}
