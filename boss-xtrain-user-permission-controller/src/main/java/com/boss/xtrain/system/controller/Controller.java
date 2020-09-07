package com.boss.xtrain.system.controller;

import com.boss.xtrain.api.annotation.ApiLog;
import com.boss.xtrain.data.convertion.common.CommonRequest;
import com.boss.xtrain.data.convertion.common.ResponseHeader;
import com.boss.xtrain.data.convertion.common.CommonResponse;
import com.boss.xtrain.exception.code.enums.system.AuthenticationCode;
import com.boss.xtrain.exception.type.BusinessException;
import com.boss.xtrain.system.center.dao.entity.UserEntity;
import com.boss.xtrain.system.center.pojo.dto.userlogin.UserLoginDTO;
import com.boss.xtrain.system.center.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName Controller
 * @Author moukex
 * @Date 2020/8/29 15:07
 * @Version 1.0
 */
@Api(tags="APP用户注册Controller")
@Slf4j
@RestController
public class Controller {


    @Autowired
    private UserServiceImpl userService;

    /**
     * @Author moukex
     * @Version  1.0
     * @Description 校验登录逻辑
     * @param commonRequest 标准请求
     * @Return CommonResponse 标准应答
     */
    @ApiLog
    @PostMapping("/checklogin")
    public CommonResponse checkLogin(@RequestBody CommonRequest<UserLoginDTO> commonRequest) throws BusinessException {
        UserLoginDTO user = commonRequest.getBody();
        String name = user.getUsername();
        String password = user.getPassword();
        UserEntity usercheck=userService.getUserByCode(name);
        if(usercheck.getPassword().equals(password)){
            Map<String, Object> map = new HashMap<>(8);
            map.put("userId", usercheck.getId());
            map.put("token",userService.createJwt(name));
            ResponseHeader responseHead = new ResponseHeader();
            responseHead.setVersion("v1.0");
            responseHead.setCode("200");
            responseHead.setMessage("认证服务");
            responseHead.setEncryptFlag(0);
            return new CommonResponse(responseHead,map);
        }else{
            throw new BusinessException(AuthenticationCode.AUTHENTICATION_CODE_USER_PASSWORD_INVALID_ERROR,new Throwable("abc") );
        }
    }
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 获取用户角色与名字
     * @param
     * @Return CommonResponse
     */
    @ApiLog
    @GetMapping("/getinfo")
    public CommonResponse info(){
        Map<String, String> map = new HashMap<>(8);
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        ResponseHeader responseHead = new ResponseHeader();
        responseHead.setVersion("v1.0");
        responseHead.setCode("200");
        responseHead.setMessage("成功");
        responseHead.setEncryptFlag(0);
        return new CommonResponse(responseHead,map);
    }
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 用户登出
     * @param
     * @Return CommonResponse
     */
    @ApiLog
    @PostMapping("/logout")
    public CommonResponse logout(){
        ResponseHeader responseHead = new ResponseHeader();
        responseHead.setVersion("v1.0");
        responseHead.setCode("200");
        responseHead.setMessage("成功");
        responseHead.setEncryptFlag(0);
        Map<String, String> map = new HashMap<>(8);
        map.put("message","success");
        return new CommonResponse(responseHead,map);
    }

}




