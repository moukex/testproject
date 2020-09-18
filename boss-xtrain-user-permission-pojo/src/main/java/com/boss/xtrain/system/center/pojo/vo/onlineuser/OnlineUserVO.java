package com.boss.xtrain.system.center.pojo.vo.onlineuser;

import lombok.*;

import java.util.Date;

/**
 * @ClassName OnlineUserVO
 * @Author 黄智锋
 * @Date 2020/9/3 12:49
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OnlineUserVO {
    /** 用户工号 */
    private String code;

    /** 用户名称 */
    private String name;

    /** 登录ip地址 */
    private String ip;

    /** 上线时间 */
    private Date onlineTime;

    /** 下线时间 */
    private Date offlineTime;

    /** 状态*/
    private int status;
}
