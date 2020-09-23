package com.boss.xtrain.system.center.pojo.query;

import lombok.*;

/**
 * @Author: Administrator
 * @Description: 字典查询传输对象
 * @Date: 2020/9/20 20:22
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DictionaryQuery {
    /** 页数 */
    private Integer pageNum;

    /** 页大小 */
    private Integer pageSize;

    /** 字典名称 */
    private String name;

    /** 字典类型 */
    private String category;

    /** 组织id */
    private Long orgId;

}
