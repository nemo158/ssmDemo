package com.demo.mms.dao;

import com.demo.mms.common.domain.Finalreport;
import org.apache.ibatis.annotations.Param;

public interface FinalreportMapper {
    Finalreport returnFinalreport(@Param("report_id") int report_id, @Param("version")int version);

    Integer selectMaxversion(int report_id);

    void insertFinalreport(Finalreport finalreport);

    void insertFinalreportpath(@Param("finalpath")String finalpath,@Param("student_id") String student_id,@Param("version") String version);
}
