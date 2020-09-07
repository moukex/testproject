package com.boss.xtrain.system.center.pojo.vo.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @ClassName ResourceVO
 * @Author 黄智锋
 * @Date 2020/9/3 12:48
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResourceVO {

    /**节点名称 */
    private String name;

    /** 编号 */
    private String code;


    /** 父亲节点 */
    private Long parentId;

    /** URL */
    private String url;


    /** 打开图标 */
    private String openImg;

    /** 关闭图标 */
    private String closeImg;

    /**
     * 资源类型(1菜单2操作)
     */
    private Integer resourceType;

    /**
     * 叶子节点(1是叶子节点,2不是)
     */
    private Byte leaf;

    /**动作 */
    private Integer action;

    /** 备注*/
    private String remark;
}
