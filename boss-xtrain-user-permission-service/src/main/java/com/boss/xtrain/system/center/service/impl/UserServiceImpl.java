package com.boss.xtrain.system.center.service.impl;

import com.boss.xtrain.exception.code.enums.business.DataCode;
import com.boss.xtrain.exception.type.ServiceException;
import com.boss.xtrain.system.center.dao.entity.UserEntity;
import com.boss.xtrain.system.center.dao.mapper.UserEntityMapper;
import com.boss.xtrain.system.center.service.service.UserService;
import com.boss.xtrain.user.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;
import java.util.*;


/**
 * @Author: moukex
 * @Description: 用户Service实现
 * @Date: 2020/9/5 19:55
 * @Version: 1.0
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    /**
     * 设置token中的参数
     */
    private  static final  String USER_ID = "userId";
    private  static final  Long EXPIRE_TIME = 1000 * 60  * 15L;
    @Resource
    UserEntityMapper userEntityMapper;
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 根据用户id查找用户
     * @param   id
     * @Return 用户实体对象
     * @throw  ServiceException 查表错误
     */
    @Cacheable(cacheNames = {"getuser"})
    @Override
    public UserEntity getUserById(Long id) {
        Example example = new Example(UserEntity.class);
        example.createCriteria().andEqualTo("id", id);
        try{
            UserEntity user=userEntityMapper.selectOneByExample(example);
            if(user!=null){
                return user;
            }else{
                log.info("查询结果为空");
                throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),DataCode.BASE_DATA_SELECT_EXCEPTION.getMessage(),new Throwable("1"));
            }
        }
        catch (Exception e){
            throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),DataCode.BASE_DATA_SELECT_EXCEPTION.getMessage(),e);
        }
    }
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 根据用户名查找用户
     * @param name 用户名
     * @Return 用户实体对象
     * @throw ServiceException 查表错误
     */
    @Cacheable(cacheNames = {"getuser1"})
    @Override
    public UserEntity getUserByName(String name) {
        Example example = new Example(UserEntity.class);
        example.createCriteria().andEqualTo("name", name);
        try{
            UserEntity user=userEntityMapper.selectOneByExample(example);
            if(user!=null){
                return user;
            }
            else{
                log.info("查询结果为空");
                throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),DataCode.BASE_DATA_SELECT_EXCEPTION.getMessage(),new Throwable("1"));
            }
        }
        catch (Exception e){
            throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),DataCode.BASE_DATA_SELECT_EXCEPTION.getMessage(),e);
        }
    }
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 获取用户id并创建token
     * @param name 用户名
     * @Return String token令牌
     */
    @Override
    public String createJwt(String name) {
        UserEntity userEntity=this.getUserByName(name);
        Long id =userEntity.getId();
        //设置当前时间
        Date now=new Date();
        //设置过期时间
        Date outtime=new Date(now.getTime()+EXPIRE_TIME);
        Map<String,Object> map =new HashMap<>();
        map.put(USER_ID,id);
        return JwtUtils.createJWT(outtime, map);
    }
}
