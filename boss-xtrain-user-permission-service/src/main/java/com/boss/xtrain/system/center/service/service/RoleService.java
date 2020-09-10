package com.boss.xtrain.system.center.service.service;

import com.boss.xtrain.system.center.dao.entity.RoleEntity;

import java.util.List;

/**
 * @Author: moukex
 * @Description: 角色Service
 * @Date: 2020/9/7 15:55
 * @Version: 1.0
 */
public interface RoleService {


    /**
     * 通过角色id获取角色
     ** @param roleId 角色id
     * @return RoleEntity 角色对象
     **/
    RoleEntity getRolebyId(Long roleId);
    /**
     * 通过用户id获取角色列表
     ** @param userId 用户Id
     * @return List 资源列表
     **/
    List<RoleEntity> queryRoleByUserId(Long userId);
}
