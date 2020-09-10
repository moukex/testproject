package com.boss.xtrain.system.center.dao.entity;

import com.boss.xtrain.data.convertion.base.entity.BaseEntity;
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
@Table(name = "t_system_param")
public class SystemParamEntity extends BaseEntity {
    /**
     * 系统参数ID
     */
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 参数类型
     */
    @Column(name = "param_type")
    private String paramType;

    /**
     * 参数项
     */
    @Column(name = "param")
    private String param;

    /**
     * 参数值
     */
    @Column(name = "value")
    private String value;

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

    /**
     * 组织ID
     */
    @Column(name = "organization_id")
    private Long organizationId;

    }
