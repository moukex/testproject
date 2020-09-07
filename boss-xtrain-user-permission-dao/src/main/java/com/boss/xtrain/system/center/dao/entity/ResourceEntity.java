package com.boss.xtrain.system.center.dao.entity;

import com.boss.xtrain.data.convertion.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;
@AllArgsConstructor
@Getter
@Setter
@Table(name = "t_resource")
public class ResourceEntity extends BaseEntity {
    /**
     * 资源ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 节点名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 租户ID
     */
    @Column(name = "tenant_id")
    private Long tenantId;

    /**
     * 节点名称
     */
    @Column(name = "code")
    private String code;

    /**
     * 父亲节点
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * url
     */
    @Column(name = "url")
    private String url;

    /**
     * 打开图标
     */
    @Column(name = "open_img")
    private String openImg;

    /**
     * 关闭图标
     */
    @Column(name = "close_img")
    private String closeImg;

    /**
     * 资源类型
     */
    @Column(name = "resource_type")
    private String resourceType;

    /**
     * 叶子
     */
    @Column(name = "leaf")
    private Byte leaf;

    /**
     * 动作
     */
    @Column(name = "action")
    private Byte action;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 状态
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
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 版本
     */
    @Column(name = "version")
    private Long version;

    }
