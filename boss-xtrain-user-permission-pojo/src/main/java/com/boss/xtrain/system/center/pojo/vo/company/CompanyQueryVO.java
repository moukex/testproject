package com.boss.xtrain.system.center.pojo.vo.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName ComanyQueryVO
 * @Author 黄智锋
 * @Date 2020/9/3 16:38
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CompanyQueryVO {
    /**公司id*/
    private Long companyId;

    /**公司名称*/
    private String name;

}
