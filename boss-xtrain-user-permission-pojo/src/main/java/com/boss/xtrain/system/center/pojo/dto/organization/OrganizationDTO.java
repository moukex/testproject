package com.boss.xtrain.system.center.pojo.dto.organization;

import com.boss.xtrain.data.convertion.base.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @ClassName OrganizationVO
 * @Author 黄智锋
 * @Date 2020/9/3 12:47
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrganizationDTO extends BaseDTO {
    /** 组织名称 */
    private String name;

}
