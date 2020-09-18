package com.boss.xtrain.system.center.dao.mapper;

import com.boss.xtrain.data.convertion.base.dao.CommonMapper;
import com.boss.xtrain.system.center.dao.entity.ResourceEntity;
import com.boss.xtrain.system.center.dao.entity.RoleEntity;
import com.boss.xtrain.system.center.dao.entity.UserEntity;

import java.util.List;

public interface UserEntityMapper extends CommonMapper<UserEntity> {
    List<RoleEntity> selectRolebyUserId(Long userid);

    List<ResourceEntity> selectResourcebyUserId(Long userid);
}
