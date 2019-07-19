package com.demo.mms.dao;

import com.demo.mms.common.domain.OpenReport;

public interface OpenReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OpenReport record);

    int insertSelective(OpenReport record);

    OpenReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpenReport record);

    int updateByPrimaryKey(OpenReport record);
}