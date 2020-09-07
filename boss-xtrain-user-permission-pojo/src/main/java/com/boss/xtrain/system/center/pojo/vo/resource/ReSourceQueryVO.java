package com.boss.xtrain.system.center.pojo.vo.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName ReSourceQueryVO
 * @Author 黄智锋
 * @Date 2020/9/3 17:24
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReSourceQueryVO {
    /**节点名称 */
    private String name;

    /** 父亲节点 */
    private Long parentId;
}
