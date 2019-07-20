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
    public Finalreport findFinalreport(int studentid,int version) {
        return finalreportMapper.returnFinalreport(studentid,version);
    }

    @Transactional
    @Override
    public Integer addMaxversion(int studentid) {
        return finalreportMapper.selectMaxversion(studentid);
    }

    @Transactional
    @Override
    public void addFinalreport(Finalreport finalreport) {
        finalreportMapper.insertFinalreport(finalreport);
    }

    @Override
    public void addFinalreportpath(String finalpath, String studentid, String version) {
        finalreportMapper.insertFinalreportpath(finalpath,studentid,version);
    }
}
