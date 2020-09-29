package com.boss.xtrain.system.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.boss.xtrain.api.annotation.ApiLog;
import com.boss.xtrain.data.convertion.base.controller.AbstractController;
import com.boss.xtrain.data.convertion.common.CommonRequest;
import com.boss.xtrain.data.convertion.common.CommonResponse;
import com.boss.xtrain.system.DictionaryApi;
import com.boss.xtrain.system.center.dao.entity.DictionaryEntity;
import com.boss.xtrain.system.center.pojo.dto.dictionary.DeleteDictionaryDTO;
import com.boss.xtrain.system.center.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.system.center.pojo.query.DictionaryQuery;
import com.boss.xtrain.system.center.service.service.DictionaryService;
import com.boss.xtrain.user.utils.CommonPage;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

/**
 * @Author: moukex
 * @Description: 字典控制类
 * @Date: 2020/9/20 20:44
 * @Version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/user/dictionary")
public class DictionaryController extends AbstractController implements DictionaryApi {
    @Autowired
    private DictionaryService dictionaryService;

    /**
     * @Author moukex
     * @Version  1.0
     * @Description 根据传回的query动态组建sql语句查字典表
     * @param commonRequest
     * @Return 标准应答
     */

    @ApiLog
    @PostMapping("/seachdictionary")
    public CommonResponse seachDictionaryWithPage(@RequestBody CommonRequest<DictionaryQuery> commonRequest){
        List<DictionaryEntity> dictionaryList;
        DictionaryQuery dictionaryQuery=commonRequest.getBody();
        dictionaryList=dictionaryService.queryAll(dictionaryQuery);
        PageInfo<DictionaryEntity> pageInfo = new PageInfo<>(dictionaryList);
        return buildSuccCommonResponse( CommonPage.restPage(pageInfo,dictionaryList));
    }
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 根据id与版本删除字典
     * @param commonRequest
     * @Return 标准应答
     */

    @ApiLog
    @PostMapping("/deletedictionary")
    public CommonResponse deleteDictionary(@RequestBody CommonRequest<List<DeleteDictionaryDTO>> commonRequest){
        log.info(commonRequest.getBody().toString());
        dictionaryService.deletedictionary(commonRequest.getBody());
        return buildSuccCommonResponse("删除成功");
    }
    /**
     * @Author moukex
     * @Version  1.0
     * @Description 添加字典
     * @param commonRequest
     * @Return 标准应答
     */
    @ApiLog
    @PostMapping("/adddictionary")
    public CommonResponse addDictionary(@RequestBody CommonRequest<DictionaryDTO> commonRequest){
        DictionaryDTO dictionaryDTO=commonRequest.getBody();
        DictionaryEntity dictionaryEntity=new DictionaryEntity();
        dictionaryEntity.setName(dictionaryDTO.getName());
        dictionaryEntity.setCategory(dictionaryDTO.getCategory());
        dictionaryEntity.setOrganizationId(dictionaryDTO.getOrganization_id());
        dictionaryEntity.setValue(dictionaryDTO.getValue());
        dictionaryEntity.setRemark(dictionaryDTO.getRemark());
        dictionaryEntity.setStatus(dictionaryDTO.getStatus());
        dictionaryEntity.setCreatedBy(dictionaryDTO.getCreated_by());
        Date now=new Date(System.currentTimeMillis());
        dictionaryEntity.setCreatedTime(now);
        dictionaryEntity.setUpdatedTime(now);
        dictionaryEntity.setVersion(1L);
        Snowflake snowflake= IdUtil.createSnowflake(15,10);
        Long onlineId=snowflake.nextId();
        dictionaryEntity.setId(onlineId);
        dictionaryService.insterdictionary(dictionaryEntity);
        return buildSuccCommonResponse("添加成功");
    }


    /**
     * @Author moukex
     * @Version  1.0
     * @Description 更新字典
     * @param commonRequest
     * @Return 标准应答
     */
    @ApiLog
    @PostMapping("/updatedictionary")
    public CommonResponse updateDictionary(@RequestBody CommonRequest<DictionaryDTO> commonRequest){
        DictionaryDTO dictionaryDTO=commonRequest.getBody();
        DictionaryEntity dictionaryEntity=new DictionaryEntity();
        dictionaryEntity.setId(dictionaryDTO.getId());
        dictionaryEntity.setName(dictionaryDTO.getName());
        dictionaryEntity.setCategory(dictionaryDTO.getCategory());
        dictionaryEntity.setOrganizationId(dictionaryDTO.getOrganization_id());
        dictionaryEntity.setValue(dictionaryDTO.getValue());
        dictionaryEntity.setRemark(dictionaryDTO.getRemark());
        dictionaryEntity.setStatus(dictionaryDTO.getStatus());
        dictionaryEntity.setUpdatedBy(dictionaryDTO.getUpdated_by());
        dictionaryEntity.setId(dictionaryDTO.getId());
        dictionaryEntity.setVersion(1L);
        Date now=new Date(System.currentTimeMillis());
        dictionaryEntity.setUpdatedTime(now);
        dictionaryService.updatedictionary(dictionaryEntity);
        return buildSuccCommonResponse("更新成功");
    }



}
