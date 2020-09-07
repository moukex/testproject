package com.boss.xtrain.system.center.pojo.vo.systemparam;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName SystemParamQueryVO
 * @Author 黄智锋
 * @Date 2020/9/3 17:23
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SystemParamQueryVO {
    /**
     * 组织机构Id
     */
    private Long orgId;
    /**
     * 参数类型
     */
    private String paramType;
    /**
     * 参数项
     */
    private  String param;
}
