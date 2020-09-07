package com.boss.xtrain.system.center.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
@AllArgsConstructor
@Getter
@Setter
@Table(name = "t_role_resource")
public class RoleResourceEntity {
    @Id
    @Column(name = "role_id")
    private Long roleId;

    @Id
    @Column(name = "resource_id")
    private Long resourceId;

}
