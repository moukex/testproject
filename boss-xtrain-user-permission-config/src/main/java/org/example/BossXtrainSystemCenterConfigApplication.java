package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BossXtrainSystemCenterConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(BossXtrainSystemCenterConfigApplication.class, args);
    }
    @GetMapping(value = "get")
    public String testGetStr() {
        return "OK";
    }

}
