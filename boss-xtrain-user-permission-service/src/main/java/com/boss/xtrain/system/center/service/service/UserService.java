package com.boss.xtrain.system.center.service.service;

import com.boss.xtrain.system.center.dao.entity.PositionEntity;
import com.boss.xtrain.system.center.dao.entity.UserEntity;
import com.boss.xtrain.system.center.pojo.dto.position.PositionDTO;
import com.boss.xtrain.system.center.pojo.dto.user.UserDTO;
import com.boss.xtrain.system.center.pojo.dto.userlogin.UserLoginDTO;

import java.util.List;

/**
 * @Author: moukex
 * @Description: 用户接口类
 * @Date: 2020/9/5 19:49
 * @Version: 1.0
 */
public interface UserService {
    int save(UserEntity entity);
    int delete(UserEntity entity);
    int update(UserEntity entity);


    /**
     * 通过用户id获取用户
     ** @param query 用户对象
     * @return User 用户对象
     **/
    List<UserEntity> queryByCondition(UserEntity query);

    /**
     * 通过用户id获取用户
     ** @param name 用户名称
     * @return User 用户对象
     **/
    UserEntity getUserByCode(String name);

    /**
     * 通过用户编码获取jwt的token并将token存到redis中
     * @param code 用户code
     * @return String token
     **/
    String createJwt(String code);

}
