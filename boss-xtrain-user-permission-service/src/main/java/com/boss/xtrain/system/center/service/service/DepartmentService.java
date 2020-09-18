package com.boss.xtrain.system.center.service.service;

import com.boss.xtrain.system.center.dao.entity.DepartmentEntity;

/**
 * @Author: moukex
 * @Description: 部门类service
 * @Date: 2020/9/18 8:54
 * @Version: 1.0
 */
public interface DepartmentService {

    /**
     * 通过部门id获取部门
     ** @param departmentid 部门id
     * @return DepartmentEntity 部门对象
     **/
    DepartmentEntity getDepartmentById(Long departmentid);

}
