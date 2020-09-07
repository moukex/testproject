package com.boss.xtrain.system.center.dao.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_online")
public class OnlineUserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 工号
     */
    @Column(name = "code")
    private String code;

    /**
     * 用户姓名
     */
    @Column(name = "name")
    private String name;

    @Column(name = "ip")
    private String ip;

    /**
     * 上线时间
     */
    @Column(name = "offline_time")
    private Date offlineTime;

    /**
     * 下线时间
     */
    @Column(name = "stop_time")
    private Integer stopTime;

    /**
     * 在线时长
     */
    @Column(name = "online_time")
    private Date onlineTime;

    /**
     * 状态位
     */
    @Column(name = "status")
    private Boolean status;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    }
