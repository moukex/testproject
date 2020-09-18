package com.boss.xtrain.system.center.service.impl;

import com.boss.xtrain.exception.code.enums.business.DataCode;
import com.boss.xtrain.exception.type.ServiceException;
import com.boss.xtrain.system.center.dao.entity.*;

import com.boss.xtrain.system.center.dao.mapper.ResourceEntityMapper;
import com.boss.xtrain.system.center.dao.mapper.RoleEntityMapper;
import com.boss.xtrain.system.center.dao.mapper.RoleResourceEntityMapper;
import com.boss.xtrain.system.center.dao.mapper.UserEntityMapper;
import com.boss.xtrain.system.center.service.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author: Administrator
 * @Description: 资源Service实现类
 * @Date: 2020/9/7 16:01
 * @Version: 1.0
 */
@Slf4j
@Component
public class ResourceServiceImpl implements ResourceService {
    @Resource
    ResourceEntityMapper resourceEntityMapper;
    @Resource
    RoleResourceEntityMapper roleResourceEntityMapper;
    @Resource
    RoleEntityMapper roleEntityMapper;
    @Resource
    UserEntityMapper userEntityMapper;
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 依照用户id查找资源列表
     * @param userid
     * @Return 资源列表
     */
    public List<ResourceEntity> queryResourceByUserId(Long userid){
        try {
            List<ResourceEntity> resources = new ArrayList<>();
            resources = userEntityMapper.selectResourcebyUserId(userid);
            return resources;
        } catch (Exception e){
            throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),e.getMessage(),e);
        }
    };
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 根据资源id查找资源
     * @param resourceId
     * @Return 资源实体对象
     * @throw ServiceException 查表错误
     */
    @Override
    public ResourceEntity getResourcebyId(Long resourceId) {
        Example example = new Example(ResourceEntity.class);
        example.createCriteria().andEqualTo("id", resourceId);
        try{
            return resourceEntityMapper.selectOneByExample(example);
        }
        catch (Exception e){
            throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),e.getMessage(),e);
        }
    }

    /**
     * @Author moukex
     * @Version  1.0
     * @Description 根据角色id查找资源列表
     * @param roleId 角色id
     * @Return list 资源列表
     * @throw ServiceException 查表错误
     */
    @Override
    public List<ResourceEntity> queryResourceByRoleId(Long roleId) {
        try{
            List<ResourceEntity> resources=new ArrayList<>();
            resources=roleEntityMapper.selectResourcebyRoleId(roleId);
            if(resources!=null){
                return resources;
            }else{
                log.info("查询结果为空");
                throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),DataCode.BASE_DATA_SELECT_EXCEPTION.getMessage(),new Throwable("1"));
            }
        }
        catch (Exception e){
            throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),e.getMessage(),e);
        }
    }
}
