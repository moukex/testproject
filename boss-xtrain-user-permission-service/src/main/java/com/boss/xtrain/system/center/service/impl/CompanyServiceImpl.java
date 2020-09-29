package com.boss.xtrain.system.center.service.impl;

import com.boss.xtrain.exception.code.enums.business.DataCode;
import com.boss.xtrain.exception.type.ServiceException;
import com.boss.xtrain.system.center.dao.entity.CompanyEntity;
import com.boss.xtrain.system.center.dao.mapper.CompanyEntityMapper;
import com.boss.xtrain.system.center.service.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;

/**
 * @Author: Administrator
 * @Description: 公司service实现
 * @Date: 2020/9/18 8:58
 * @Version: 1.0
 */
@Slf4j
@Component
public class CompanyServiceImpl implements CompanyService {

    @Resource
    CompanyEntityMapper companyEntityMapper;
    /**
     * 通过公司id查询公司
     * @param companyid 公司id
     * @return 公司对象
     */
    @Override
    public CompanyEntity getCompanyById(Long companyid) {
        Example example = new Example(CompanyEntity.class);
        example.createCriteria().andEqualTo("id", companyid);
        try{
            CompanyEntity company=companyEntityMapper.selectOneByExample(example);
            if(company!=null){
                return company;
            }else{
                log.info("查询结果为空");
                throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),DataCode.BASE_DATA_SELECT_EXCEPTION.getMessage(),new Throwable("1"));
            }
        }
        catch (Exception e){
            throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),e.getMessage(),e);
        }
    }
}
