package com.boss.xtrain.system.center.dao.entity;

import com.boss.xtrain.data.convertion.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_time")
    private Date createdTime;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_time")
    private Date updatedTime;
}
