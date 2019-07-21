package com.demo.mms.service;

import com.demo.mms.common.domain.FinalReport;
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
    public FinalReport findFinalreport(int studentid, int version) {
        return finalreportMapper.returnFinalreport(studentid,version);
    }

    @Transactional
    @Override
    public Integer addMaxversion(int studentid) {
        return finalreportMapper.selectMaxversion(studentid);
    }

    @Transactional
    @Override
    public void addFinalreport(FinalReport finalreport) {
        finalreportMapper.insertFinalreport(finalreport);
    }

    @Override
    public void addFinalreportpath(String originalFilename,String finalpath, String studentid, String version) {
        finalreportMapper.insertFinalreportpath(originalFilename,finalpath,studentid,version);
        System.out.println("1; "+originalFilename);
    }

    @Override
    public void addFinalresultpath(String originalFilename,String finalpath, String studentid, String version) {
        finalreportMapper.insertFinalresultpath(originalFilename,finalpath,studentid,version);
        System.out.println("2; "+originalFilename);
    }

    @Override
    public void addFinalotherpath(String originalFilename,String finalpath, String studentid, String version) {
        finalreportMapper.insertFinalotherpath(originalFilename,finalpath,studentid,version);
        System.out.println("3; "+originalFilename);
    }
}
