package com.boss.xtrain.system.center.pojo.vo.organization;

import com.boss.xtrain.data.convertion.base.vo.BaseVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName OrganizationQueryVO
 * @Author 黄智锋
 * @Date 2020/9/3 16:43
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrganizationQueryVO extends BaseVO {

    /**组织id*/
    private long id;

    /*组织名称*/
    private String name;
}
