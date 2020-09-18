package com.boss.xtrain.system.center.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
