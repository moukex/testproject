package com.boss.xtrain.system.controller;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.boss.xtrain.data.convertion.base.controller.AbstractController;
import com.boss.xtrain.data.convertion.common.CommonRequest;
import com.boss.xtrain.data.convertion.common.CommonResponse;
import com.boss.xtrain.system.center.dao.entity.OnlineUserEntity;
import com.boss.xtrain.system.center.dao.entity.UserEntity;
import com.boss.xtrain.system.center.pojo.dto.onlineuser.OnlineUserDTO;
import com.boss.xtrain.system.center.service.impl.UserServiceImpl;
import com.boss.xtrain.system.center.service.impl.UseronlineServiceImpl;
import com.boss.xtrain.utils.SpringContextUtil;
import com.boss.xtrain.utils.webUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import java.net.InetSocketAddress;

import javax.websocket.*;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: moukex
 * @Description: 用户在线类Controller
 * @Date: 2020/9/10 17:15
 * @Version: 1.0
 */
@Slf4j
@RestController
@ServerEndpoint(value = "/user/websocket/{userOnlineInfoId}")
@RequestMapping("/user")
public class UserOnlineController extends AbstractController {

    UseronlineServiceImpl useronlineService;


    UserServiceImpl userService;

    private static ConcurrentHashMap<Long, Long> webSocketMap = new ConcurrentHashMap<>();

    /**
     * @Author moukex
     * @Version  1.0
     * @Description 开启连接时获取ip地址以及将登录信息表插入用户在线表中
     * @param userOnlineInfoId 用户id
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam(value = "userOnlineInfoId") Long userOnlineInfoId, Session session)  {
        //获取ip地址
        InetSocketAddress remoteAddress = webUtils.getRemoteAddress(session);
        //动态获取spring上下文
        ApplicationContext act = SpringContextUtil.getApplicationContext();
        //注入bean
        useronlineService=act.getBean(UseronlineServiceImpl.class);
        userService=act.getBean(UserServiceImpl.class);
        UserEntity user=userService.getUserById(userOnlineInfoId);
        OnlineUserEntity onlineUserEntity=new OnlineUserEntity();
        Snowflake snowflake= IdUtil.createSnowflake(15,10);
        Long onlineId=snowflake.nextId();
        //雪花算法生成id
        onlineUserEntity.setId(onlineId);
        onlineUserEntity.setUserId(userOnlineInfoId);
        onlineUserEntity.setName(user.getName());
        onlineUserEntity.setCode(user.getCode());
        Date now=new Date(System.currentTimeMillis());
        onlineUserEntity.setIp(remoteAddress.toString());
        onlineUserEntity.setStatus(true);
        if(null!=webSocketMap.get(userOnlineInfoId)){
            Date offtime=new Date(System.currentTimeMillis());
            onlineUserEntity.setOfflineTime(offtime);
            onlineUserEntity.setStatus(false);
            useronlineService.update(onlineUserEntity);
        }
        onlineUserEntity.setOnlineTime(now);
        useronlineService.insert(onlineUserEntity);
        webSocketMap.put(userOnlineInfoId,onlineId);
    }

    /**
     * @Author moukex
     * @Version  1.0
     * @Description websocket连接错误中断时发送错误消息
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("webSocket运行发生错误！",error);
    }

    /**
     * @Author moukex
     * @Version  1.0
     * @Description 连接中断即为用户下线，添加下线时间以及设置状态status为0；
     * @param userOnlineInfoId 用户id
     */
    @OnClose
    public void onClose(@PathParam(value = "userOnlineInfoId") Long userOnlineInfoId){
        //动态获取spring上下文
        ApplicationContext act = SpringContextUtil.getApplicationContext();
        //注入bean
        useronlineService=act.getBean(UseronlineServiceImpl.class);
        if(null!=webSocketMap.get(userOnlineInfoId)){
            log.info("用户id为{}已断开连接",userOnlineInfoId);
            OnlineUserEntity onlineUserEntity=useronlineService.queryOnlineUserById(webSocketMap.get(userOnlineInfoId));
            Date offtime=new Date(System.currentTimeMillis());
            onlineUserEntity.setStatus(false);
            onlineUserEntity.setOfflineTime(offtime);
            useronlineService.update(onlineUserEntity);
            webSocketMap.remove(userOnlineInfoId);
        }else{
            log.info("该用户为离线状态");
        }
    }

    /**
     * @Author moukex
     * @Version  1.0
     * @Description 查询用户在线列表
     * @param commonRequest 标准请求
     * @Return CommonResponse 标准应答
     */
    @PostMapping("/getOnLineUser")
    public CommonResponse infouseronline(@RequestBody CommonRequest<OnlineUserDTO> commonRequest){
        //动态获取spring上下文
        ApplicationContext act = SpringContextUtil.getApplicationContext();
        //注入bean
        useronlineService=act.getBean(UseronlineServiceImpl.class);
        List<OnlineUserEntity> onlineusers=new ArrayList<>();
        OnlineUserDTO queryonlineuser=commonRequest.getBody();
        onlineusers=useronlineService.queryAll(queryonlineuser);
        return buildSuccCommonResponse(onlineusers);
    }

    /**
     * @Author moukex
     * @Version  1.0
     * @Description 强制下线
     * @param commonRequest 标准请求
     * @Return CommonResponse 标准应答
     */
    public CommonResponse loginout(@RequestBody CommonRequest<OnlineUserDTO> commonRequest){
        //动态获取spring上下文
        ApplicationContext act = SpringContextUtil.getApplicationContext();
        //注入bean
        useronlineService=act.getBean(UseronlineServiceImpl.class);
        userService=act.getBean(UserServiceImpl.class);
        Map map =new HashMap();
        return buildSuccCommonResponse(map);

    }

}
