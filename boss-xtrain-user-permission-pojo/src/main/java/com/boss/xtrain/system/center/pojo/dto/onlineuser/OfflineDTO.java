package com.boss.xtrain.system.center.pojo.dto.onlineuser;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @Author: moukex
 * @Description: 下线用DTO
 * @Date: 2020/9/22 16:08
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OfflineDTO {
    /**
     * 用户在线id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long onlineuserid;
    /**
     * 用户名
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String onlineusername;

}
