package com.boss.xtrain.system.center.pojo.vo.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName DictionaryQueryVO
 * @Author 黄智锋
 * @Date 2020/9/3 16:51
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DictionaryQueryVO {
    /**
     * 字典名称
     */
    private String name;
    /**
     * 字典类型
     */
    private String category;

    /**
     * 组织机构Id
     */
    private Long orgId;
}
