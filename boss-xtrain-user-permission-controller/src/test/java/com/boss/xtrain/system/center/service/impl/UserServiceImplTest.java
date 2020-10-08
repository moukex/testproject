package com.boss.xtrain.system.center.service.impl;

import com.boss.xtrain.system.center.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: moukex
 * @Description: 用户鉴权类单元测试
 * @Date: 2020/10/8 8:44
 * @Version: 1.0
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    void getUserById() {
        assertEquals(userService.getUserById(4L),userService.getUserByName("admin"));
    }

    @Test
    void getUserByName() {
        assertEquals(userService.getUserById(4L),userService.getUserByName("admin"));
    }

    @Test
    void createJwt() {
        assertNotNull(userService.createJwt("people"));
    }
}