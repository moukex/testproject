package com.boss.xtrain.system.center.service.service;

import com.boss.xtrain.system.center.dao.entity.OnlineUserEntity;
import com.boss.xtrain.system.center.pojo.query.UserQuery;
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
    List<OnlineUserEntity> queryAll(UserQuery userQuery);
    /**
     * 插入用户在线表，表示用户在线
     **/
    int insert(OnlineUserEntity onlineUserEntity);

    int delete(OnlineUserEntity onlineUserEntity);
    /**
     * 更新用户状态，表示用户离线
     **/
    int update(OnlineUserEntity onlineUserEntity);

    OnlineUserEntity queryOnlineUserById(Long onlineuserid);

    boolean judgeStatus(Long userid);

}
