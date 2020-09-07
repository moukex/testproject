package com.boss.xtrain.system.center.dao.entity;

import com.boss.xtrain.data.convertion.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "t_company")
public class CompanyEntity extends BaseEntity {
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
     * 公司编号
     */
    @Column(name = "code")
    private String code;

    /**
     * 助记码
     */
    @Column(name = "mnemonic_code")
    private String mnemonicCode;

    @Column(name = "master")
    private String master;

    /**
     * 税号
     */
    @Column(name = "tax")
    private String tax;

    /**
     * 传真
     */
    @Column(name = "fax")
    private String fax;

    /**
     * 电话
     */
    @Column(name = "tel")
    private String tel;

    /**
     * address
     */
    @Column(name = "address")
    private String address;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 网址
     */
    @Column(name = "website")
    private String website;

    /**
     * 公司ID
     */
    @Column(name = "organization_id")
    private Long organizationId;

    /** 创建者 */
    @Column(name = "created_by")
    private Long createdBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_time")
    private Date createdTime;

    /** 更新者 */
    @Column(name = "updated_by")
    private Long updatedBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_time")
    private Date updatedTime;

    /** 状态*/
    @Column(name = "status")
    private Boolean status;

    /** 版本 */
    @Column(name = "version")
    private Long version;

}
