package com.boss.xtrain.system.center.service.service;

import com.boss.xtrain.system.center.pojo.dto.company.CompanyDTO;
import com.boss.xtrain.system.center.dao.entity.CompanyEntity;

import java.util.List;

/**
 * @ClassName CompanyService
 * @Author 黄智锋
 * @Date 2020/9/4 15:09
 * @Version 1.0
 */
public interface CompanyService {
    int save(CompanyEntity entity);
    int delete(CompanyEntity entity);
    int update(CompanyEntity entity);
    List<CompanyEntity> queryByCondition(CompanyDTO query);
}
