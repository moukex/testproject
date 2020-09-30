package com.boss.xtrain.system.center.service.impl;

import com.boss.xtrain.exception.code.enums.business.DataCode;
import com.boss.xtrain.exception.type.ServiceException;
import com.boss.xtrain.system.center.dao.entity.OnlineUserEntity;
import com.boss.xtrain.system.center.dao.mapper.OnlineUserEntityMapper;
import com.boss.xtrain.system.center.pojo.query.UserQuery;
import com.boss.xtrain.system.center.service.service.UseronlineService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: moukex
 * @Description: 用户在线实现类
 * @Date: 2020/9/10 17:04
 * @Version: 1.0
 */
@Service
public class UseronlineServiceImpl implements UseronlineService {
    @Resource
    OnlineUserEntityMapper onlineUserEntityMapper;
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 根据传回的条件查询所有的在线用户信息表
     * @param userQuery
     * @Return  list
     */
    @Override
    public List<OnlineUserEntity> queryAll(UserQuery userQuery) {
        Integer pageNum = userQuery.getPageNum();
        Integer pageSize = userQuery.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        Example e = new Example(OnlineUserEntity.class);
        Example.Criteria c = e.createCriteria();
        if(!"".equals(userQuery.getCode())){
            c.andEqualTo("code",userQuery.getCode());
        }
        if(!"".equals(userQuery.getName())){
            c.andEqualTo("name",userQuery.getName());
        }
        if(null!=userQuery.getOnlineTime()){
            c.andGreaterThan("onlineTime",userQuery.getOnlineTime());
        }
        if(null!=userQuery.getOfflineTime()){
            c.andLessThan("offlineTime",userQuery.getOfflineTime());
        }
        if("".equals(userQuery.getCode())&& "".equals(userQuery.getName()) && null==userQuery.getOnlineTime() && null==userQuery.getOfflineTime())
        {
            try {
                Example e2 = new Example(OnlineUserEntity.class);
                e2.orderBy("status").desc();
                return onlineUserEntityMapper.selectByExample(e2);
            }catch (Exception ex){
                throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),DataCode.BASE_DATA_SELECT_EXCEPTION.getMessage(),ex);
            }
        }else{
            try{
                e.orderBy("status").desc();
                return onlineUserEntityMapper.selectByExample(e);
            }catch (Exception ex){
                throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),DataCode.BASE_DATA_SELECT_EXCEPTION.getMessage(),ex);
            }
        }
    }
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 插入用户在线表，表示用户在线
     * @param onlineUserEntity
     * @Return 1
     */
    @Override
    public int insert(OnlineUserEntity onlineUserEntity) {
        try{
            return onlineUserEntityMapper.insert(onlineUserEntity);
        }catch (Exception ex){
            throw new ServiceException(DataCode.BASE_DATA_INSERT_EXCEPTION.getCode(),DataCode.BASE_DATA_SELECT_EXCEPTION.getMessage(),ex);
        }
    }

    @Override
    public int delete(OnlineUserEntity onlineUserEntity) {
        return 0;
    }

    @Override
    public int update(OnlineUserEntity onlineUserEntity) {
        try{
            return onlineUserEntityMapper.updateByPrimaryKey(onlineUserEntity);
        }catch (Exception ex){
            throw new ServiceException(DataCode.BASE_DATA_UPDATE_EXCEPTION.getCode(),DataCode.BASE_DATA_SELECT_EXCEPTION.getMessage(),ex);
        }
    }


    /**
     * @Author moukex
     * @Version  1.0
     * @Description 根据id查询在线用户
     * @param onlineuserid
     * @Return  单个在线用户
     */
    @Override
    public OnlineUserEntity queryOnlineUserById(Long onlineuserid) {
        Example example = new Example(OnlineUserEntity.class);
        example.createCriteria().andEqualTo("id", onlineuserid);
        try{
            return onlineUserEntityMapper.selectOneByExample(example);
        }
        catch (Exception e){
            throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),DataCode.BASE_DATA_SELECT_EXCEPTION.getMessage(),e);
        }
    }
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 判断用户是否在线
     * @param userid
     * @Return  true or false
     */
    public boolean judgeStatus(Long userid){
        Example example = new Example(OnlineUserEntity.class);
        example.createCriteria().andEqualTo("userId", userid);
        try{
            List<OnlineUserEntity> onlineUserEntities=onlineUserEntityMapper.selectByExample(example);
            for(OnlineUserEntity item:onlineUserEntities){
                if(item.getStatus()){
                    return true;
                }
            }
        }
        catch (Exception e){
            throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),DataCode.BASE_DATA_SELECT_EXCEPTION.getMessage(),e);
        }
        return false;
    }



}
