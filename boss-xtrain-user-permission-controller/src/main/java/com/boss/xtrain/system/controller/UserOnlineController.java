package com.boss.xtrain.system.controller;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.boss.xtrain.data.convertion.base.controller.AbstractController;
import com.boss.xtrain.data.convertion.common.CommonRequest;
import com.boss.xtrain.data.convertion.common.CommonResponse;
import com.boss.xtrain.system.center.dao.entity.OnlineUserEntity;
import com.boss.xtrain.system.center.dao.entity.UserEntity;
import com.boss.xtrain.system.center.pojo.dto.onlineuser.OfflineDTO;
import com.boss.xtrain.system.center.pojo.query.UserQuery;
import com.boss.xtrain.system.center.service.impl.UserServiceImpl;
import com.boss.xtrain.system.center.service.impl.UseronlineServiceImpl;
import com.boss.xtrain.system.center.service.service.UserService;
import com.boss.xtrain.system.center.service.service.UseronlineService;
import com.boss.xtrain.user.utils.CommonPage;
import com.boss.xtrain.user.utils.SpringContextUtil;
import com.boss.xtrain.user.utils.webUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import java.net.InetSocketAddress;

import javax.websocket.*;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: moukex
 * @Description: 用户在线类Controller
 * @Date: 2020/9/10 17:15
 * @Version: 1.0
 */
@Api(tags="用户在线controller")
@Slf4j
@RestController
@ServerEndpoint(value = "/user/websocket/{userOnlineInfoId}")
@RequestMapping("/user/onlineuser")
public class UserOnlineController extends AbstractController {

    private UseronlineService useronlineService;


    private UserService userService;

    private static ConcurrentHashMap<String, Long> webSocketMap = new ConcurrentHashMap<>();

    /**
     * @Author moukex
     * @Version  1.0
     * @Description 开启连接时获取ip地址以及将登录信息表插入用户在线表中
     * @param userOnlineInfoId 用户id
     * @param session
     */
    @ApiOperation("websocket开启连接时运行方法")
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
        String username=user.getName();
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
        //用户已经在线，挤掉原来用户
        if(null!=webSocketMap.get(username)){
            OnlineUserEntity onlineUserEntity1=useronlineService.queryOnlineUserById(webSocketMap.get(username));;
            Date offtime=new Date(System.currentTimeMillis());
            onlineUserEntity1.setStatus(false);
            onlineUserEntity1.setOfflineTime(offtime);
            useronlineService.update(onlineUserEntity1);
            webSocketMap.remove(username);
            log.info("目前在线用户为："+webSocketMap.toString());
        }
        onlineUserEntity.setOnlineTime(now);
        useronlineService.insert(onlineUserEntity);
        webSocketMap.put(username,onlineId);
        log.info("目前在线用户为："+webSocketMap.toString());
    }

    /**
     * @Author moukex
     * @Version  1.0
     * @Description websocket连接错误中断时发送错误消息
     */
    @ApiOperation("websocket运行出错时运行方法")
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
    @ApiOperation("websocket关闭连接时运行的方法")
    @OnClose
    public void onClose(@PathParam(value = "userOnlineInfoId") Long userOnlineInfoId){
        //动态获取spring上下文
        ApplicationContext act = SpringContextUtil.getApplicationContext();
        //注入bean
        useronlineService=act.getBean(UseronlineServiceImpl.class);
        userService=act.getBean(UserServiceImpl.class);
        UserEntity user=userService.getUserById(userOnlineInfoId);
        String username=user.getName();
        if(null!=webSocketMap.get(username)){
            log.info("用户id为{}已断开连接",userOnlineInfoId);
            OnlineUserEntity onlineUserEntity=useronlineService.queryOnlineUserById(webSocketMap.get(username));
            Date offtime=new Date(System.currentTimeMillis());
            onlineUserEntity.setStatus(false);
            onlineUserEntity.setOfflineTime(offtime);
            useronlineService.update(onlineUserEntity);
            webSocketMap.remove(username);
            log.info("目前在线用户为："+webSocketMap.toString());
        }else{
            log.info("该用户为离线状态");
            log.info("目前在线用户为："+webSocketMap.toString());
        }
    }

    /**
     * @Author moukex
     * @Version  1.0
     * @Description 查询用户在线列表
     * @param commonRequest 标准请求
     * @Return CommonResponse 标准应答
     */
    @ApiOperation("获取用户在线表")
    @PostMapping("/getOnLineUser")
    public CommonResponse infouseronlineWithPage(@RequestBody CommonRequest<UserQuery> commonRequest){
        //动态获取spring上下文
        ApplicationContext act = SpringContextUtil.getApplicationContext();
        //注入bean
        useronlineService=act.getBean(UseronlineServiceImpl.class);
        List<OnlineUserEntity> onlineusers;
        UserQuery queryonlineuser=commonRequest.getBody();
        onlineusers=useronlineService.queryAll(queryonlineuser);
        PageInfo<OnlineUserEntity> pageInfo = new PageInfo<>(onlineusers);
        return buildSuccCommonResponse( CommonPage.restPage(pageInfo,onlineusers));
    }

    /**
     * @Author moukex
     * @Version  1.0
     * @Description 强制下线
     * @param commonRequest 需要强制下线的用户在线id
     * @Return CommonResponse 标准应答
     */
    @ApiOperation("强制下线")
    @PostMapping("/logoutOnLineUser")
    public CommonResponse loginout(@RequestBody CommonRequest<OfflineDTO> commonRequest){
        //动态获取spring上下文
        ApplicationContext act = SpringContextUtil.getApplicationContext();
        //注入bean
        useronlineService=act.getBean(UseronlineServiceImpl.class);
        userService=act.getBean(UserServiceImpl.class);
        OfflineDTO offline=commonRequest.getBody();
        String username=offline.getOnlineusername();
        if(null!=webSocketMap.get(username)) {
            OnlineUserEntity onlineUserEntity=useronlineService.queryOnlineUserById(webSocketMap.get(username));
            Date offtime=new Date(System.currentTimeMillis());
            onlineUserEntity.setStatus(false);
            onlineUserEntity.setOfflineTime(offtime);
            useronlineService.update(onlineUserEntity);
            webSocketMap.remove(username);
            return buildSuccCommonResponse("成功下线");
        }else{


            return buildSuccCommonResponse("该用户已为离线状态，下线失败");
        }
    }
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 转发service，判断用户在线状态
     * @param userid
     * @Return true or false
     */
    @ApiOperation("判断在线状态")
    @PostMapping("/judgeonline")
    public Boolean judgeOnline(Long userid){
    return useronlineService.judgeStatus(userid);
    }

}
