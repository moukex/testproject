package com.boss.xtrain.system.center.pojo.dto.onlineuser;

import lombok.*;

import java.util.Date;

/**
 * @ClassName OnlineUserDTO
 * @Author 黄智锋
 * @Date 2020/9/3 12:49
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OnlineUserDTO {
    /** 用户工号 */
    private String Code;

    /** 用户名称 */
    private String name;

    /** 上线时间 */
    private Date onlineTime;

    /** 下线时间 */
    private Date offlineTime;

    /** 状态*/
    private int status;
}
