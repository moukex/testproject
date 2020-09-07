package com.boss.xtrain.system.center.service.service;

import com.boss.xtrain.system.center.pojo.dto.position.PositionDTO;
import com.boss.xtrain.system.center.dao.entity.PositionEntity;

import java.util.List;

/**
 * @ClassName PositionService
 * @Author 黄智锋
 * @Date 2020/9/4 15:58
 * @Version 1.0
 */
public interface PositionService {
    int save(PositionEntity entity);
    int delete(PositionEntity entity);
    int update(PositionEntity entity);
    List<PositionEntity> queryByCondition(PositionDTO query);
}
