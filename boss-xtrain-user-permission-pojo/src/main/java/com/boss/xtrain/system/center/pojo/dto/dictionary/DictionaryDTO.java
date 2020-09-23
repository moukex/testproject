package com.boss.xtrain.system.center.pojo.dto.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * @Author: moukex
 * @Description: 字典DTO类
 * @Date: 2020/9/21 9:54
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DictionaryDTO {

    /** 字典id */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private  Long id;
    /** 字典名称 */
    private String name;
    /** 字典类型 */
    private String category;
    /** 字典值 */
    private String value;
    /** 字典备注 */
    private String remark;

    private Boolean status;

    private Long created_by;

    private Date created_time;

    private Long updated_by;

    private Date updated_time;

    private Integer version;
    /** 组织id */
    private Long organization_id;


}
