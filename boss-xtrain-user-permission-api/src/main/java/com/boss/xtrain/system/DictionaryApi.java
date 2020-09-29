package com.boss.xtrain.system;

import com.boss.xtrain.data.convertion.common.CommonRequest;
import com.boss.xtrain.data.convertion.common.CommonResponse;
import com.boss.xtrain.system.center.pojo.dto.dictionary.DeleteDictionaryDTO;
import com.boss.xtrain.system.center.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.system.center.pojo.query.DictionaryQuery;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * @Author: Administrator
 * @Description: 字典api接口
 * @Date: 2020/9/23 14:32
 * @Version: 1.0
 */
@RequestMapping("/user")
public interface DictionaryApi {
    @PostMapping("/seachdictionary")
    CommonResponse seachDictionaryWithPage(@RequestBody CommonRequest<DictionaryQuery> commonRequest);

    @PostMapping("/deletedictionary")
    CommonResponse deleteDictionary(@RequestBody CommonRequest<List<DeleteDictionaryDTO>> commonRequest);

    @PostMapping("/adddictionary")
    CommonResponse addDictionary(@RequestBody CommonRequest<DictionaryDTO> commonRequest);

    @PostMapping("/updatedictionary")
    CommonResponse updateDictionary(@RequestBody CommonRequest<DictionaryDTO> commonRequest);
}
