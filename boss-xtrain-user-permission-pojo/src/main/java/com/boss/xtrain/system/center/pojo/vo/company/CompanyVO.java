package com.boss.xtrain.system.center.pojo.vo.company;

import com.boss.xtrain.data.convertion.base.vo.BaseVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @ClassName CompanyVO
 * @Author 黄智锋
 * @Date 2020/9/3 12:47
 * @Version 1.0
 */

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CompanyVO extends BaseVO {

    /** 公司名称 */
    private String name;

    /** 公司编号 */
    private String code;

    /** 助记码 */
    private String mnemonicCode;

    /** master */
    private String master;

    /** 税号 */
    private String tax;

    /** 传真 */
    private String fax;

    /** 电话 */
    private String tel;

    /** 更新者 */
    private String address;

    /** 邮箱 */
    private String email;

    /** 网址 */
    private String website;

    /** 组织ID */
    private String organizationId;
}
