package com.demo.mms.dao;

import com.demo.mms.common.domain.FinalReport;

public interface FinalReportMapper {
    int deleteByPrimaryKey(Integer reportid);

    int insert(FinalReport record);

    int insertSelective(FinalReport record);

    FinalReport selectByPrimaryKey(Integer reportid);

    int updateByPrimaryKeySelective(FinalReport record);

    int updateByPrimaryKey(FinalReport record);
}