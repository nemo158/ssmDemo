package com.demo.mms.dao;

import com.demo.mms.common.domain.FinalReport;
import org.apache.ibatis.annotations.Param;

public interface FinalreportMapper {
    FinalReport returnFinalreport(@Param("studentid") int studentid, @Param("version") int version);

    Integer selectMaxversion(int studentid);

    void insertFinalreport(FinalReport finalreport);

    void insertFinalreportpath(@Param("originalFilename") String originalFilename,@Param("finalpath") String finalpath, @Param("studentid") String studentid, @Param("version") String version);

    void insertFinalresultpath(@Param("originalFilename") String originalFilename,@Param("finalpath") String finalpath, @Param("studentid") String studentid, @Param("version") String version);

    void insertFinalotherpath(@Param("originalFilename") String originalFilename,@Param("finalpath") String finalpath, @Param("studentid") String studentid, @Param("version") String version);
}
