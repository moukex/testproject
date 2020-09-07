package com.boss.xtrain.system.center.pojo.vo.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName RoleQuery
 * @Author 黄智锋
 * @Date 2020/9/3 17:24
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoleQuery {
    /** 角色名称 */
    private String name;
    /**公司id*/
    private String companyId;
}
