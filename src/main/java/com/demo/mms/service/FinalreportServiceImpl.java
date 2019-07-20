package com.demo.mms.service;

import com.demo.mms.common.domain.Finalreport;
import com.demo.mms.dao.FinalreportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FinalreportServiceImpl implements FinalreportService {
    @Autowired
    FinalreportMapper finalreportMapper;

    @Transactional
    @Override
    public Finalreport findFinalreport(int report_id,int version) {
        return finalreportMapper.returnFinalreport(report_id,version);
    }

    @Transactional
    @Override
    public Integer addMaxversion(int report_id) {
        return finalreportMapper.selectMaxversion(report_id);
    }

    @Transactional
    @Override
    public void addFinalreport(Finalreport finalreport) {
        finalreportMapper.insertFinalreport(finalreport);
    }

    @Override
    public void addFinalreportpath(String finalpath, String student_id, String version) {
        finalreportMapper.insertFinalreportpath(finalpath,student_id,version);
    }
}
