package com.boss.xtrain.system.center.pojo.vo.department;

import com.boss.xtrain.data.convertion.base.vo.BaseVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName DepartmentVO
 * @Author 黄智锋
 * @Date 2020/9/3 12:48
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepartmentVO extends BaseVO {
    /** 部门名称 */
    private String name;

    /** 部门编号 */
    private String code;

    /** 助记码 */
    private String mnemonicCode;

    /** 负责人 */
    private String master;

    /** 部门级别 */
    private String level;

    /** 部门描述 */
    private String describe;

    /** 公司id */
    private String companyId;
}
