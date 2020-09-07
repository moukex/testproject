package com.boss.xtrain.system.center.pojo.dto.position;

import com.boss.xtrain.data.convertion.base.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName PositionVO
 * @Author 黄智锋
 * @Date 2020/9/3 15:06
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PositionDTO extends BaseDTO {
    /**
     * 职位名称
     */
    private String name;

    /** 组织id */
    private long organizationId;

}
