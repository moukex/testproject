package com.boss.xtrain.system.center.pojo.query;

import lombok.*;

import java.util.Date;

/**
 * @Author: Administrator
 * @Description: 用户在线查询数据类
 * @Date: 2020/9/18 16:46
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserQuery {
    /** 页数 */
    private Integer pageNum;

    /** 页大小 */
    private Integer pageSize;

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
