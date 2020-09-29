package com.boss.xtrain.system.center.service.service;

import com.boss.xtrain.system.center.dao.entity.DictionaryEntity;
import com.boss.xtrain.system.center.pojo.dto.dictionary.DeleteDictionaryDTO;
import com.boss.xtrain.system.center.pojo.query.DictionaryQuery;

import java.util.List;

/**
 * @Author: moukex
 * @Description: 字典Service
 * @Date: 2020/9/20 20:20
 * @Version: 1.0
 */
public interface DictionaryService {


    List<DictionaryEntity> queryAll(DictionaryQuery dictionaryQuery);

    int deletedictionary(List<DeleteDictionaryDTO> deleteDictionaryDTO);

    int insterdictionary(DictionaryEntity dictionaryEntity);

    int updatedictionary(DictionaryEntity dictionaryEntity);

}
