package com.boss.xtrain.system.center.pojo.dto.userlogin;

import com.boss.xtrain.data.convertion.base.dto.BaseDTO;
import lombok.*;

/**
 * @Author: moukex
 * @Description: 用户登录DTO
 * @Date: 2020/9/5 19:54
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserLoginDTO {
    /** 用户名称 */
    private String username;
    /** 密码 */
    private String password;
}
