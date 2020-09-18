package com.boss.xtrain.system.center.service.service;

import com.boss.xtrain.system.center.dao.entity.OnlineUserEntity;
import com.boss.xtrain.system.center.pojo.dto.onlineuser.OnlineUserDTO;

import javax.websocket.Session;
import java.net.InetSocketAddress;
import java.util.List;

/**
 * @Author: moukex
 * @Description: 用户在线Service
 * @Date: 2020/9/10 16:28
 * @Version: 1.0
 */
public interface UseronlineService {

    /**
     * 获取所有用户在线表
     * @return  list 用户在线列表
     **/
    List<OnlineUserEntity> queryAll(OnlineUserDTO onlineUserDTO);
    /**
     * 插入用户在线表，表示用户在线
     **/
    int insert(OnlineUserEntity onlineUserEntity);
    int delete(OnlineUserEntity onlineUserEntity);

    int update(OnlineUserEntity onlineUserEntity);

    OnlineUserEntity queryOnlineUserById(Long onlineuserid);



}