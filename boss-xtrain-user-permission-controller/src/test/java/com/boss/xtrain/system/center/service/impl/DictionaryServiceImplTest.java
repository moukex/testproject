package com.boss.xtrain.system.center.service.impl;

import com.boss.xtrain.system.center.dao.entity.DictionaryEntity;
import com.boss.xtrain.system.center.pojo.dto.dictionary.DeleteDictionaryDTO;
import com.boss.xtrain.system.center.pojo.query.DictionaryQuery;
import com.boss.xtrain.system.center.service.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: moukex
 * @Description: 字典服务单元测试
 * @Date: 2020/10/8 8:45
 * @Version: 1.0
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DictionaryServiceImplTest {

    @Autowired
    private DictionaryService dictionaryService;

    @Test
    void queryAll() {
        DictionaryQuery dictionaryQuery = new DictionaryQuery();
        dictionaryQuery.setPageNum(1);
        dictionaryQuery.setOrgId(819098775921664L);
        dictionaryQuery.setCategory("");
        dictionaryQuery.setPageSize(5);
        dictionaryQuery.setName("");
        assertNotNull(dictionaryService.queryAll(dictionaryQuery));
    }

    @Test
    void deletedictionary() {
        DeleteDictionaryDTO deleteDictionaryDTO=new DeleteDictionaryDTO();
        deleteDictionaryDTO.setId(1309399795883110400L);
        deleteDictionaryDTO.setVersion(1);
        List<DeleteDictionaryDTO> list=new ArrayList<>();
        list.add(deleteDictionaryDTO);
        assertNotNull(dictionaryService.deletedictionary(list));
    }

    @Test
    void insterdictionary() {
        DictionaryEntity dictionaryEntity=new DictionaryEntity();
        dictionaryEntity.setId(1309399795883110400L);
        Date now=new Date(System.currentTimeMillis());
        dictionaryEntity.setUpdatedTime(now);
        dictionaryEntity.setCreatedTime(now);
        dictionaryEntity.setRemark("考试评价");
        dictionaryEntity.setValue("6");
        dictionaryEntity.setOrganizationId(819098775921664L);
        dictionaryEntity.setCategory("评价");
        dictionaryEntity.setCreatedBy(4L);
        dictionaryEntity.setName("Commond");
        dictionaryEntity.setStatus(true);
        dictionaryEntity.setVersion(1L);
        assertNotNull(dictionaryService.insterdictionary(dictionaryEntity));


    }

    @Test
    void updatedictionary() {
        DictionaryEntity dictionaryEntity=new DictionaryEntity();
        dictionaryEntity.setId(1309399795883110400L);
        Date now=new Date(System.currentTimeMillis());
        dictionaryEntity.setUpdatedTime(now);
        dictionaryEntity.setCreatedTime(now);
        dictionaryEntity.setRemark("修改项");
        dictionaryEntity.setValue("6");
        dictionaryEntity.setOrganizationId(819098775921664L);
        dictionaryEntity.setCategory("评价");
        dictionaryEntity.setCreatedBy(4L);
        dictionaryEntity.setName("修改项");
        dictionaryEntity.setStatus(true);
        dictionaryEntity.setVersion(1L);
        assertNotNull(dictionaryService.updatedictionary(dictionaryEntity));
    }
}