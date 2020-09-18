package com.boss.xtrain.system.center.service.service;

import com.boss.xtrain.system.center.dao.entity.ResourceEntity;

import java.util.List;


/**
 * @Author: moukex
 * @Description: 资源Service
 * @Date: 2020/9/7 15:58
 * @Version: 1.0
 */
public interface ResourceService {

    /**
     * 通过资源id获取资源
     ** @param resourceId 资源id
     * @return ResourceEntity 资源对象
     **/
    ResourceEntity getResourcebyId (Long resourceId);
    /**
     * 通过角色id获取资源列表
     ** @param roleId 角色Id
     * @return List 资源列表
     **/
    List<ResourceEntity> queryResourceByRoleId(Long roleId);
    /**
     * 通过用户id获取资源列表
     ** @param userid 用户Id
     * @return List 资源列表
     **/
    List<ResourceEntity> queryResourceByUserId(Long userid);
}
