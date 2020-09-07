package com.boss.xtrain.system.center.pojo.vo.position;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName PositionQueryVO
 * @Author 黄智锋
 * @Date 2020/9/3 17:24
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PositionQueryVO {
    /**
     * 职位名称
     */
    private String name;

    /**
     * 职位编号
     */
    private String code;

    /**
     * 职位备注
     */
    private String remark;

    /** 公司id */
    private long companyId;
}
