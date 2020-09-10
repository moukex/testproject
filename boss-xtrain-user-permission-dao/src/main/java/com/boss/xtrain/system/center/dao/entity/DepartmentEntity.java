package com.boss.xtrain.system.center.dao.entity;

import com.boss.xtrain.data.convertion.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "t_department")
public class DepartmentEntity extends BaseEntity {
    /**
     * 部门ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 部门名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 助记码
     */
    @Column(name = "mnemonic_code")
    private String mnemonicCode;

    /**
     * 部门编号
     */
    @Column(name = "code")
    private String code;

    /**
     * 部门级别
     */
    @Column(name = "level")
    private String level;

    /**
     * 上级部门
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 负责人
     */
    @Column(name = "master")
    private String master;

    /**
     * 部门描述
     */
    @Column(name = "describe")
    private String describe;

    /**
     * 公司ID
     */
    @Column(name = "company_id")
    private Long companyId;


}
