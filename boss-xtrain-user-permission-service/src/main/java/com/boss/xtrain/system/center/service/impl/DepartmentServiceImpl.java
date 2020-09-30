package com.boss.xtrain.system.center.service.impl;

import com.boss.xtrain.exception.code.enums.business.DataCode;
import com.boss.xtrain.exception.type.ServiceException;
import com.boss.xtrain.system.center.dao.entity.DepartmentEntity;
import com.boss.xtrain.system.center.dao.mapper.DepartmentEntityMapper;
import com.boss.xtrain.system.center.service.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;

/**
 * @Author: Administrator
 * @Description: 部门Service实现
 * @Date: 2020/9/18 8:59
 * @Version: 1.0
 */
@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Resource
    DepartmentEntityMapper departmentEntityMapper;

    /**
     * 通过部门id查询部门
     * @param departmentid 部门id
     * @return 部门对象
     */
    @Override
    public DepartmentEntity getDepartmentById(Long departmentid) {
        Example example = new Example(DepartmentEntity.class);
        example.createCriteria().andEqualTo("id", departmentid);
        try{
            DepartmentEntity department=departmentEntityMapper.selectOneByExample(example);
            if(department!=null){
                return department;
            }else{
                log.info("查询结果为空");
                throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),DataCode.BASE_DATA_SELECT_EXCEPTION.getMessage(),new Throwable("1"));
            }
        }
        catch (Exception e){
            throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),DataCode.BASE_DATA_SELECT_EXCEPTION.getMessage(),e);
        }
    }
}
