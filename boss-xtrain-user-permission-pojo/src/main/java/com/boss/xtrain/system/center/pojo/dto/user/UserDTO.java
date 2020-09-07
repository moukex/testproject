package com.boss.xtrain.system.center.pojo.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName UserVO
 * @Author 黄智锋
 * @Date 2020/9/3 15:30
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    /** 用户名称 */
    private String name;

    /** 用户工号 */
    private String code;

    /** 密码 */
    private String password;

    /** 头像 */
    private String profilePicture;

    /** 性别 */
    private String sex;

    /** 电话 */
    private String tel;

    /** 生日 */
    private String birthday;

    /** 邮箱 */
    private String email;

    /** 其他联系方式 */
    private String other;

    /** 备注 */
    private String remark;

    /** 部门名称 */
    private String department;

    /** 职位名称 */
    private String position;

    /** 公司id */
    private String company;
}
