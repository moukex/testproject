package com.boss.xtrain.system.center.dao.entity;

import com.boss.xtrain.data.convertion.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "t_organization")
public class OrganizationEntity extends BaseEntity {
    /**
     * 组织机构ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 机构名
     */
    @Column(name = "name")
    private String name;

    /**
     * 机构代码
     */
    @Column(name = "code")
    private String code;

    /**
     * 负责人
     */
    @Column(name = "master")
    private String master;

    /**
     * 电话
     */
    @Column(name = "tel")
    private String tel;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 状态位
     */
    @Column(name = "status")
    private Boolean status;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private Long createdBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 修改人
     */
    @Column(name = "updated_by")
    private Long updatedBy;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 版本
     */
    @Column(name = "version")
    private Long version;

    }
