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
@Table(name = "t_position")
public class PositionEntity extends BaseEntity {
    /**
     * 职位ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 职位名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 职位编号
     */
    @Column(name = "code")
    private String code;

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

    /**
     * 公司ID
     */
    @Column(name = "company_id")
    private Long companyId;

    }
