package com.boss.xtrain.system.center.service.impl;

import com.boss.xtrain.system.center.dao.mapper.CompanyEntityMapper;
import com.boss.xtrain.system.center.pojo.dto.company.CompanyDTO;
import com.boss.xtrain.system.center.dao.entity.CompanyEntity;
import com.boss.xtrain.system.center.dao.entity.OrganizationEntity;
import com.boss.xtrain.system.center.service.service.CompanyService;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CompanyImpl
 * @Author 黄智锋
 * @Date 2020/9/4 15:07
 * @Version 1.0
 */
public class CompanyImpl implements CompanyService {
    @Resource
    CompanyEntityMapper companyEntityMapper;
    /**
     * @param: [entity]
     * @return: int
     * @description: 保存公司
     */
    @Override
    public int save(CompanyEntity entity) {
        return companyEntityMapper.insert(entity);
    }
    /**
     * @param: [entity]
     * @return: int
     * @description: 删除公司信息
     */
    @Override
    public int delete(CompanyEntity entity) {
        return companyEntityMapper.delete(entity);
    }
    /**
     * @param: [entity]
     * @return: int
     * @description: 更新公司信息
     */
    @Override
    public int update(CompanyEntity entity) {
        return companyEntityMapper.updateByPrimaryKey(entity);
    }
    /**
     * @param: [query]
     * @return: java.util.List<com.boss.xtrain.system.center.entity.CompanyEntity>
     * @description: 根据名字查询
     */
    @Override
    public List<CompanyEntity> queryByCondition(CompanyDTO query) {
        Example example=new Example(OrganizationEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name",query.getName());
        return companyEntityMapper.selectByExample(example);
    }
}
