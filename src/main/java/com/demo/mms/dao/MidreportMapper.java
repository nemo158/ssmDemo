package com.demo.mms.dao;

import com.demo.mms.common.domain.Midreport;
import org.apache.ibatis.annotations.Param;

public interface MidreportMapper {
    int insertMidreport(Midreport midreport);
    Integer selectMaxversion(int course_id);
    Midreport selectMidreport(@Param("course_id") int course_id, @Param("version") int version);
    void insertMidreportpath(@Param("finalpath")String finalpath,@Param("course_id")String course_id,@Param("version")String version,@Param("originalFilename")String originalFilename);
}
