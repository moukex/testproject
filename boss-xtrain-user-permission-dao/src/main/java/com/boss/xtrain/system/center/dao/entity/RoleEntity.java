package com.boss.xtrain.system.center.dao.entity;

import com.boss.xtrain.data.convertion.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "t_role")
public class RoleEntity extends BaseEntity {
    /**
     * 角色ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 角色名
     */
    @Column(name = "name")
    private String name;

    /**
     * 角色代码
     */
    @Column(name = "code")
    private String code;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;


    /**
     * 组织ID
     */
    @Column(name = "organization_id")
    private Long organizationId;

    /**
     * 公司ID
     */
    @Column(name = "company_id")
    private Long companyId;

   }
