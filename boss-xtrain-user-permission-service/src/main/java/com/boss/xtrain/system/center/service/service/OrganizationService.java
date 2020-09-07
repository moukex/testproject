package com.boss.xtrain.system.center.service.service;

import com.boss.xtrain.system.center.pojo.dto.organization.OrganizationDTO;
import com.boss.xtrain.system.center.dao.entity.OrganizationEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrganizationImpl
 * @Author 黄智锋
 * @Date 2020/9/3 17:55
 * @Version 1.0
 */
@Service
public interface OrganizationService {
    int save(OrganizationEntity entity);
    int delete(OrganizationEntity entity);
    int update(OrganizationEntity entity);
    public List<OrganizationEntity> queryByCondition(OrganizationDTO query);
}
