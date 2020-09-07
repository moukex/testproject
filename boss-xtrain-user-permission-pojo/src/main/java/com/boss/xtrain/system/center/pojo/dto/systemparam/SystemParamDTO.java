package com.boss.xtrain.system.center.pojo.dto.systemparam;

import com.boss.xtrain.data.convertion.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

/**
 * @ClassName SystemParamVO
 * @Author 黄智锋
 * @Date 2020/9/3 12:49
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SystemParamDTO extends BaseEntity {
    /** 参数类型 */
    @Column(name = "param_type")
    private String paramType;

    /** 参数项 */
    @Column(name = "param")
    private String param;

    /** 参数值 */
    @Column(name = "value")
    private String value;

}
