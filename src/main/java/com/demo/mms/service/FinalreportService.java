package com.demo.mms.service;

import com.demo.mms.common.domain.FinalReport;

public interface FinalreportService {
    FinalReport findFinalreport(int studentid, int version);

    Integer addMaxversion(int studentid);

    void addFinalreport(FinalReport finalreport);

    void addFinalreportpath(String originalFilename,String finalpath, String studentid, String version);

    void addFinalresultpath(String originalFilename,String finalpath, String toString, String toString1);

    void addFinalotherpath(String originalFilename,String finalpath, String toString, String toString1);
}
