package com.demo.mms.service;

import com.demo.mms.common.domain.Finalreport;

public interface FinalreportService {
    Finalreport findFinalreport(int report_id,int version);

    Integer addMaxversion(int report_id);

    void addFinalreport(Finalreport finalreport);

    void addFinalreportpath(String finalpath, String student_id, String version);
}
