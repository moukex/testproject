package com.boss.xtrain.system.center.service.impl;

import com.boss.xtrain.system.center.dao.mapper.PositionEntityMapper;
import com.boss.xtrain.system.center.pojo.dto.position.PositionDTO;
import com.boss.xtrain.system.center.dao.entity.PositionEntity;
import com.boss.xtrain.system.center.service.service.PositionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: moukex
 * @Description: 职务Service实现
 * @Date: 2020/9/5 19:55
 * @Version: 1.0
 */
@Component
public class PositionImpl implements PositionService {
    @Resource
    PositionEntityMapper positionEntityMapper;
    @Override
    public int save(PositionEntity entity) {
        return positionEntityMapper.insert(entity);
    }

    @Override
    public int delete(PositionEntity entity) {
        return positionEntityMapper.delete(entity);
    }

    @Override
    public int update(PositionEntity entity) {
        return positionEntityMapper.updateByPrimaryKey(entity);
    }

    @Override
    public List<PositionEntity> queryByCondition(PositionDTO query) {
        return positionEntityMapper.queryByName(query);
    }
}
