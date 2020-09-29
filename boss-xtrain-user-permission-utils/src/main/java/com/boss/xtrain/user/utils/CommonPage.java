package com.boss.xtrain.user.utils;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import java.util.List;

/**
 * @Author: moukex
 * @Description: 分页工具
 * @Date: 2020/9/18 17:10
 * @Version: 1.0
 */
@Data
public class CommonPage<P,V> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<V> list;


    /**
     * 将PageHelper分页后的list转为分页的信息
     */
    public static <P,V> CommonPage<P, V> restPage(PageInfo<P> pageInfo, List<V> list){
        CommonPage<P,V> result = new CommonPage<>();
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(list);
        return result;
    }

    public static <P,V> CommonPage<P,V> restPage(List<V> list){
        CommonPage<P,V> result = new CommonPage<>();
        PageInfo<V> pageInfo =  new PageInfo<>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

}
