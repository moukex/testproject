package com.boss.xtrain.system.center.dao.mapper;

import com.boss.xtrain.data.convertion.base.dao.CommonMapper;
import com.boss.xtrain.system.center.dao.entity.PositionEntity;
import com.boss.xtrain.system.center.pojo.dto.position.PositionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface PositionEntityMapper extends CommonMapper<PositionEntity> {
    @Select("select * from t_position where name like CONCAT('%',#{name},'%') and company_id in (select id from t_company where id=#{organizationId})")
    public List<PositionEntity> queryByName(PositionDTO positionDTO);


}
