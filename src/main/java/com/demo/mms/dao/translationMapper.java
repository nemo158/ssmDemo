package com.demo.mms.dao;

import com.demo.mms.common.domain.translation;

public interface translationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(translation record);

    int insertSelective(translation record);

    translation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(translation record);

    int updateByPrimaryKey(translation record);
}