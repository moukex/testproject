package com.boss.xtrain.system.center.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@AllArgsConstructor
@Getter
@Setter
@Table(name = "t_user_role")
public class UserRoleEntity {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 角色ID
     */
    @Id
    @Column(name = "t_r_id")
    private Long tRId;

}
