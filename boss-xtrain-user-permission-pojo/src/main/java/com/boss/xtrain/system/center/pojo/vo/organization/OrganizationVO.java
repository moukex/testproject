package com.boss.xtrain.system.center.pojo.vo.organization;

import com.boss.xtrain.data.convertion.base.vo.BaseVO;
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
public class OrganizationVO extends BaseVO {

    /** 公司名称 */
    private String name;

    /** 公司编号 */
    private String code;

    /** master */
    private String master;

    /** 电话 */
    private String tel;

    /** 地址 */
    private String address;

}
