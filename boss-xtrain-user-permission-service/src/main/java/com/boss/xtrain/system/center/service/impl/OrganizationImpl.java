package com.boss.xtrain.system.center.service.impl;

import com.boss.xtrain.system.center.dao.mapper.OrganizationEntityMapper;
import com.boss.xtrain.system.center.pojo.dto.organization.OrganizationDTO;
import com.boss.xtrain.system.center.dao.entity.OrganizationEntity;
import com.boss.xtrain.system.center.service.service.OrganizationService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName OrganizationService
 * @Author 黄智锋
 * @Date 2020/9/4 11:27
 * @Version 1.0
 */
@Service
public class OrganizationImpl implements OrganizationService {
    @Resource
    OrganizationEntityMapper organizationEntityMapper;
    /**
     * @param: [entity]
     * @return: int
     * @description: 保存组织信息
     */
    @Override
    public int save(OrganizationEntity entity) {
        return organizationEntityMapper.insert(entity);
    }
    /**
     * @param: [entity]
     * @return: int
     * @description: 删除某个组织
     */
    @Override
    public int delete(OrganizationEntity entity) {
        return organizationEntityMapper.delete(entity);
    }
    /**
     * @param: [entity]
     * @return: int
     * @description: 更新某条组织信息
     */
    @Override
    public int update(OrganizationEntity entity) {
        return organizationEntityMapper.updateByPrimaryKey(entity);
    }
    /**
     * @param: [query]
     * @return: java.util.List<com.boss.xtrain.system.center.entity.OrganizationEntity>
     * @description: 根据组织名字查询
     */
    @Override
    public List<OrganizationEntity> queryByCondition(OrganizationDTO query) {
        Example example=new Example(OrganizationEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name","%"+query.getName()+"%");
        return organizationEntityMapper.selectByExample(example);
    }
}
