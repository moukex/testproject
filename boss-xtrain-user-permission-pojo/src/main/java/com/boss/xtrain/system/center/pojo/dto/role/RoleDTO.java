package com.boss.xtrain.system.center.pojo.dto.role;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName RoleVO
 * @Author 黄智锋
 * @Date 2020/9/3 12:48
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoleDTO {

    /** 角色名称 */
    private String name;

    /** 角色编号 */
    private String code;

    /**角色备注*/
    private String remark;

    /**组织id*/
    private String organizationId;

    /**公司id*/
    private String companyId;
}
