package com.boss.xtrain.system.center.pojo.dto.dictionary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @Author: moukex
 * @Description: 删除用dto
 * @Date: 2020/9/21 8:35
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DeleteDictionaryDTO {

    /** 字典id */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /** 字典版本 */
    private int version;
}
