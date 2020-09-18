package com.boss.xtrain.system.center.dao.mapper;

import com.boss.xtrain.data.convertion.base.dao.CommonMapper;
import com.boss.xtrain.system.center.dao.entity.ResourceEntity;
import com.boss.xtrain.system.center.dao.entity.RoleEntity;

import java.util.List;

public interface RoleEntityMapper extends CommonMapper<RoleEntity> {
    List<ResourceEntity> selectResourcebyRoleId(Long roleid);
}
