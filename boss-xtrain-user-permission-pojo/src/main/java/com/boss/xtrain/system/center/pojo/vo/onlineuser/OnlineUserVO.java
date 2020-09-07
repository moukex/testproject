package com.boss.xtrain.system.center.pojo.vo.onlineuser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName OnlineUserVO
 * @Author 黄智锋
 * @Date 2020/9/3 12:49
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OnlineUserVO {
    /** 用户id */
    private long userId;

    /** 用户名称 */
    private long name;

    /** 登录ip地址 */
    private String ip;

    /** 上线时间 */
    private String offlineTime;

    /** 上线时间 */
    private String stopTime;

    /** 在线时间 */
    private String onlineTime;
}
