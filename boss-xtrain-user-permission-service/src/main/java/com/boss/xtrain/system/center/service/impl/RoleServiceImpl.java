package com.boss.xtrain.system.center.service.impl;

import com.boss.xtrain.exception.code.enums.business.DataCode;
import com.boss.xtrain.exception.type.ServiceException;
import com.boss.xtrain.system.center.dao.entity.RoleEntity;
import com.boss.xtrain.system.center.dao.entity.UserEntity;
import com.boss.xtrain.system.center.dao.entity.UserRoleEntity;
import com.boss.xtrain.system.center.dao.mapper.RoleEntityMapper;
import com.boss.xtrain.system.center.dao.mapper.UserRoleEntityMapper;
import com.boss.xtrain.system.center.service.service.RoleService;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: moukex
 * @Description: 角色Service实现类
 * @Date: 2020/9/7 16:01
 * @Version: 1.0
 */
@Component
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleEntityMapper roleEntityMapper;
    @Resource
    UserRoleEntityMapper userRoleEntityMapper;

    /**
     * @Author moukex
     * @Version  1.0
     * @Description 根据角色id获取角色
     * @param roleId
     * @Return 角色实体对象
     */
    @Override
    public RoleEntity getRolebyId(Long roleId) {
        Example example = new Example(UserEntity.class);
        example.createCriteria().andEqualTo("id", roleId);
        try{
            return roleEntityMapper.selectOneByExample(example);
        }
        catch (Exception e){
            throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),e.getMessage(),e);
        }
    }
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 根据用户id查找角色
     * @param userId
     * @Return list 角色实体列表
     */
    @Override
    public List<RoleEntity> queryRoleByUserId(Long userId) {
        Example example = new Example(UserRoleEntity.class);
        example.createCriteria().andEqualTo("id", userId);
        try{
            List<UserRoleEntity> URlist= userRoleEntityMapper.selectByExample(example);
            List<RoleEntity> roles=new ArrayList<>();
            for(UserRoleEntity UR :URlist){
                Long roleid = UR.getTRId();
                roles.add(getRolebyId(roleid));
            }
            return roles;
        }
        catch (Exception e){
            throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),e.getMessage(),e);
        }

    }
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 根据用户id查询角色名
     * @param userId 用户id
     * @Return list 角色名列表
     */
    @Override
    public List<String> queryNameRoleByUserId(Long userId) {
        Example example = new Example(UserRoleEntity.class);
        example.createCriteria().andEqualTo("id", userId);
        try{
            List<UserRoleEntity> URlist= userRoleEntityMapper.selectByExample(example);
            List<String> roles=new ArrayList<>();
            for(UserRoleEntity UR :URlist){
                Long roleid = UR.getTRId();
                roles.add(getRolebyId(roleid).getName());
            }
            return roles;
        }
        catch (Exception e){
            throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),e.getMessage(),e);
        }
    }
}
