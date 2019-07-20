package com.demo.mms.service;

import com.demo.mms.common.domain.Finalreport;

public interface FinalreportService {
    Finalreport findFinalreport(int studentid,int version);

    Integer addMaxversion(int studentid);

    void addFinalreport(Finalreport finalreport);

    void addFinalreportpath(String finalpath, String studentid, String version);

    void addFinalresultpath(String finalpath, String toString, String toString1);

    void addFinalotherpath(String finalpath, String toString, String toString1);
}
