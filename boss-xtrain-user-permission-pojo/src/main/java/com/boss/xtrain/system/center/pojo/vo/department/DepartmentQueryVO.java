package com.boss.xtrain.system.center.pojo.vo.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @ClassName DepartmentQueryVO
 * @Author 黄智锋
 * @Date 2020/9/3 16:42
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepartmentQueryVO {
    @NotNull
    private Long companyId;
    /**
     *部门名称
     */
    private String name;
    /**
     *部门级别
     */
    private String level;

}
