package com.boss.xtrain.system;

import com.boss.xtrain.data.convertion.common.CommonRequest;
import com.boss.xtrain.data.convertion.common.CommonResponse;
import com.boss.xtrain.system.center.pojo.dto.userlogin.UserLoginDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Administrator
 * @Description: 用户认证API接口
 * @Date: 2020/9/23 14:31
 * @Version: 1.0
 */
@RequestMapping("/user")
public interface UserApi {
    @PostMapping("/login")
    CommonResponse login(@RequestBody CommonRequest<UserLoginDTO> commonRequest);

    @GetMapping("/getinfo")
    CommonResponse getinfo(String token);

    @GetMapping("/getlist")
    CommonResponse getList(String token);

    @PostMapping("/logout")
    CommonResponse logout();
}
