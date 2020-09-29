package com.boss.xtrain.system.center.service.service;

import com.boss.xtrain.system.center.dao.entity.CompanyEntity;

/**
 * @Author: moukex
 * @Description: 公司类service
 * @Date: 2020/9/18 8:53
 * @Version: 1.0
 */
public interface CompanyService {

    /**
     * 通过公司id获取公司
     ** @param companyid 公司id
     * @return CompanyEntity 公司对象
     **/
    CompanyEntity getCompanyById(Long companyid);


    Long getOrganizationIdbyId(Long companyid);
}
