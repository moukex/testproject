package com.boss.xtrain.system.controller;

import com.boss.xtrain.api.annotation.ApiLog;
import com.boss.xtrain.data.convertion.base.controller.AbstractController;
import com.boss.xtrain.data.convertion.common.CommonRequest;
import com.boss.xtrain.data.convertion.common.CommonResponse;
import com.boss.xtrain.exception.code.enums.system.AuthenticationCode;
import com.boss.xtrain.exception.type.BusinessException;
import com.boss.xtrain.system.UserApi;
import com.boss.xtrain.system.center.dao.entity.ResourceEntity;
import com.boss.xtrain.system.center.dao.entity.UserEntity;
import com.boss.xtrain.system.center.dao.mapper.CompanyEntityMapper;
import com.boss.xtrain.system.center.pojo.dto.userlogin.UserLoginDTO;
import com.boss.xtrain.system.center.service.service.*;
import com.boss.xtrain.user.utils.JwtUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @ClassName Controller
 * @Author moukex
 * @Date 2020/8/29 15:07
 * @Version 1.0
 */
@Api(tags="用户认证与授权controller")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController implements UserApi {


    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private UseronlineService useronlineService;
    @Autowired
    private CompanyService companyService;


    /**
     * @Author moukex
     * @Version  1.0
     * @Description 校验登录逻辑
     * @param commonRequest 标准请求
     * @Return CommonResponse 标准应答
     */
    @ApiLog
    @PostMapping("/login")
    public CommonResponse login(@RequestBody CommonRequest<UserLoginDTO> commonRequest) {
        UserLoginDTO user = commonRequest.getBody();
        String name = user.getUsername();
        String password = user.getPassword();
        UserEntity usercheck=userService.getUserByName(name);
        if(useronlineService.judgeStatus(usercheck.getId())){
            log.info("{}用户在线",name);
        }else {
            log.info("{}用户不在线",name);
        }
        if(usercheck.getPassword().equals(password)){
            Map<String, Object> map = new HashMap<>(8);
            map.put("userId", usercheck.getId());
            map.put("token",userService.createJwt(name));
            return buildSuccCommonResponse(map);
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
    public CommonResponse getinfo(String token){
        Map map ;
        map=JwtUtils.parseJWT(token);
        Long id=Long.valueOf(String.valueOf(map.get("userId")));
        List<String> roles;
        roles=roleService.queryNameRoleByUserId(id);
        UserEntity user=userService.getUserById(id);
        String name=user.getName();
        Long companyid=user.getCompanyId();
        Long departmentid=user.getDepartment();
        Long organizationId=companyService.getOrganizationIdbyId(companyid);
        Map<String, Object> remap = new HashMap<>(8);
        remap.put("roles",roles);
        remap.put("name",name);
        remap.put("id",id);
        remap.put("organizationId",organizationId);
        remap.put("company_id",companyid);
        remap.put("department_id",departmentid);
        remap.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return buildSuccCommonResponse(remap);
    }
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 获取资源列表
     * @param token 角色令牌
     * @Return CommonResponse
     */
    @ApiLog
    @GetMapping("/getlist")
    public  CommonResponse getList(String token) {
        Map map;
        map = JwtUtils.parseJWT(token);
        Long id = Long.valueOf(String.valueOf(map.get("userId")));
        List<Integer> resourcelist = new ArrayList<>();
        List<ResourceEntity> newresources;
        newresources = resourceService.queryResourceByUserId(id);
        //初始化资源列表
        for (int i = 0; i <= 30; i++) {
            resourcelist.add(1);
        }
        //根据资源列表初始化资源权限表
        for (ResourceEntity res : newresources) {
            if (res != null) {
                resourcelist.set(res.getNumber(), 0);
            } else {
                log.info("该资源为空");
            }
        }
            return buildSuccCommonResponse(resourcelist);
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
        Map<String, String> map = new HashMap<>(8);
        map.put("message","success");
        return buildSuccCommonResponse(map);
    }
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 通过用户id获取资源表，然后查询url是否在资源表中
     * @param  userid 用户id
     * @param url 访问路径
     * @Return
     */
    @ApiLog
    @PostMapping("/judgeuser")
    public boolean judgePermission(Long userid,String url){
        List<ResourceEntity> newresources;
        newresources = resourceService.queryResourceByUserId(userid);
        for(ResourceEntity res : newresources){
            if(res.getUrl().contains(url)){
                return true;
            }
        }
        return false;
    }

}




