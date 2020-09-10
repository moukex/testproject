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
@Table(name = "t_dictionary")
public class DictionaryEntity extends BaseEntity {
    /**
     * 字典id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 字典名
     */
    @Column(name = "name")
    private String name;

    /**
     * 字典类型
     */
    @Column(name = "category")
    private String category;

    /**
     * 字典值
     */
    @Column(name = "value")
    private String value;

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

}
