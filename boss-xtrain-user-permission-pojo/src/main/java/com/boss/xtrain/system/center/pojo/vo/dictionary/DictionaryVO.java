package com.boss.xtrain.system.center.pojo.vo.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName DictionaryVO
 * @Author 黄智锋
 * @Date 2020/9/3 17:25
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DictionaryVO {
    /** 字典名称 */
    private String name;

    /** 字典类型 */
    private String category;

    /** 字典值 */
    private String value;

    /** 备注 */
    private String remark;

    /** 组织id */
    private String organizationId;
}
