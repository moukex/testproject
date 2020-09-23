package com.boss.xtrain.system.center.service.impl;

import com.boss.xtrain.exception.code.enums.business.DataCode;
import com.boss.xtrain.exception.type.ServiceException;
import com.boss.xtrain.system.center.dao.entity.DictionaryEntity;
import com.boss.xtrain.system.center.dao.mapper.DictionaryEntityMapper;
import com.boss.xtrain.system.center.pojo.dto.dictionary.DeleteDictionaryDTO;
import com.boss.xtrain.system.center.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.system.center.pojo.query.DictionaryQuery;
import com.boss.xtrain.system.center.service.service.DictionaryService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: moukex
 * @Description: 字典Service实现类
 * @Date: 2020/9/20 20:27
 * @Version: 1.0
 */
@Component
public class DictionaryServiceImpl implements DictionaryService {

    @Resource
    DictionaryEntityMapper dictionaryEntityMapper;
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 根据条件查询字典列表
     * @param dictionaryQuery
     * @Return list 字典列表
     */
    @Override
    public List<DictionaryEntity> queryAll(DictionaryQuery dictionaryQuery) {
        Integer pageNum = dictionaryQuery.getPageNum();
        Integer pageSize = dictionaryQuery.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        Example e = new Example(DictionaryEntity.class);
        Example.Criteria c = e.createCriteria();
        if(!"".equals(dictionaryQuery.getName())){
            c.andEqualTo("name",dictionaryQuery.getName());
        }if(!"".equals(dictionaryQuery.getCategory())){
            c.andEqualTo("category",dictionaryQuery.getCategory());
        }
        if("".equals(dictionaryQuery.getName()) && "".equals(dictionaryQuery.getName())){
            try{
                return dictionaryEntityMapper.selectAll();
            }catch (Exception ex){
                throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),ex.getMessage(),ex);
            }
        }else{
            try{
                return dictionaryEntityMapper.selectByExample(e);
            }catch (Exception ex){
                throw new ServiceException(DataCode.BASE_DATA_SELECT_EXCEPTION.getCode(),ex.getMessage(),ex);
            }
        }
    }

    @Override
    public int deletedictionary(List<DeleteDictionaryDTO> deleteDictionaryDTO) {
        Example example = new Example(DictionaryEntity.class);
        for(DeleteDictionaryDTO dto:deleteDictionaryDTO){
            Example.Criteria criteria =  example.createCriteria();
            criteria.andEqualTo("id",dto.getId()).andEqualTo("version",dto.getVersion());
            example.or(criteria);
        }
        return dictionaryEntityMapper.deleteByExample(example);
    }

    @Override
    public int insterdictionary(DictionaryEntity dictionaryEntity) {
        dictionaryEntity.setVersion(1L);
        try{
            return dictionaryEntityMapper.insertSelective(dictionaryEntity);
        }catch (Exception e){
            throw new ServiceException(DataCode.BASE_DATA_INSERT_EXCEPTION,e);
        }

    }

    @Override
    public int updatedictionary(DictionaryEntity dictionaryEntity) {
        Example example = new Example(DictionaryEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",dictionaryEntity.getId()).andEqualTo("version",dictionaryEntity.getVersion());
        try{
            return dictionaryEntityMapper.updateByExample(dictionaryEntity,example);
        }catch (Exception e){
            throw new ServiceException(DataCode.BASE_DATA_UPDATE_EXCEPTION,e);
        }

    }

}
