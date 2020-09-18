package com.boss.xtrain.system.center.service.impl;

import com.boss.xtrain.exception.code.enums.business.DataCode;
import com.boss.xtrain.exception.type.ServiceException;
import com.boss.xtrain.system.center.dao.entity.OnlineUserEntity;
import com.boss.xtrain.system.center.dao.entity.UserEntity;
import com.boss.xtrain.system.center.dao.mapper.OnlineUserEntityMapper;
import com.boss.xtrain.system.center.pojo.dto.onlineuser.OnlineUserDTO;
import com.boss.xtrain.system.center.service.service.UseronlineService;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.websocket.Session;
import java.net.InetSocketAddress;
import java.util.List;

/**
 * @Author: moukex
 * @Description: 用户在线实现类
 * @Date: 2020/9/10 17:04
 * @Version: 1.0
 */
@Component
public class UseronlineServiceImpl implements UseronlineService {
    @Resource
    OnlineUserEntityMapper onlineUserEntityMapper;
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 根据传回的条件查询所有的在线用户信息表
     * @param onlineUserDTO
     * @Return  list
     */
    @Override
    public List<OnlineUserEntity> queryAll(OnlineUserDTO onlineUserDTO) {
        Example e = new Example(OnlineUserEntity.class);
        Example.Criteria c = e.createCriteria();
        if(!"".equals(onlineUserDTO.getCode())){
            c.andEqualTo("code",onlineUserDTO.getCode());
        } if(!"".equals(onlineUserDTO.getName())){
            c.andEqualTo("name",onlineUserDTO.getName());
        } if(null!=onlineUserDTO.getOnlineTime()){
            c.andGreaterThan("onlineTime",onlineUserDTO.getOnlineTime());
        }if(null!=onlineUserDTO.getOfflineTime()){
            c.andLessThan("offlineTime",onlineUserDTO.getOfflineTime());
        }
        if("".equals(onlineUserDTO.getCode())&& "".equals(onlineUserDTO.getName()) && null==onlineUserDTO.getOnlineTime() && null==onlineUserDTO.getOfflineTime())
        {
            try {
                return onlineUserEntityMapper.selectAll();
            }catch (Exception ex){
                throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),ex.getMessage(),ex);
            }
        }else{
            try{
                return onlineUserEntityMapper.selectByExample(e);
            }catch (Exception ex){
                throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),ex.getMessage(),ex);
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
            throw new ServiceException(DataCode.BASE_DATA_INSERT_EXCEPTION.getCode(),ex.getMessage(),ex);
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
            throw new ServiceException(DataCode.BASE_DATA_UPDATE_EXCEPTION.getCode(),ex.getMessage(),ex);
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
            throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),e.getMessage(),e);
        }
    }


}
