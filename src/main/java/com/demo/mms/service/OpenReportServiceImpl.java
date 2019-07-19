package com.demo.mms.service;

import com.demo.mms.common.domain.OpenReport;
import com.demo.mms.dao.OpenReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OpenReportServiceImpl implements OpenReportService{
    @Autowired
    OpenReportMapper openReportMapper;

    @Transactional
    @Override
    public void addOpenReport(OpenReport openReport) { openReportMapper.insert(openReport); }

    @Override
    public OpenReport getOpenreport(Integer id){ return openReportMapper.selectByPrimaryKey(id); }
}
