package com.boss.xtrain.system.center.service.impl;

import com.boss.xtrain.system.center.pojo.query.UserQuery;
import com.boss.xtrain.system.center.service.service.UseronlineService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: moukex
 * @Description: 用户在线单元测试
 * @Date: 2020/10/8 8:44
 * @Version: 1.0
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UseronlineServiceImplTest {
    @Autowired
    private UseronlineService useronlineService;

    @Test
    void queryAll() {
        UserQuery userQuery=new UserQuery();
        userQuery.setCode("");
        userQuery.setName("");
        userQuery.setOfflineTime(null);
        userQuery.setOnlineTime(null);
        userQuery.setPageNum(1);
        userQuery.setPageSize(5);
        assertNotNull(useronlineService.queryAll(userQuery));
    }
    @Test
    void queryOnlineUserById() {
        assertNotNull(useronlineService.queryOnlineUserById(1313763910831370240L));
    }

    @Test
    void judgeStatus() {
        assertNotNull(useronlineService.judgeStatus(4L));
    }
}