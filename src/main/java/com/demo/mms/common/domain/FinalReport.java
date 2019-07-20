package com.demo.mms.common.domain;

import java.util.Date;

public class FinalReport {
    private Integer reportid;

    private Integer studentid;

    private String fildaddress;

    private Integer score1;

    private Integer score2;

    private Integer score3;

    private String advice;

    private Date commitTime;

    public Integer getReportid() {
        return reportid;
    }

    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getFildaddress() {
        return fildaddress;
    }

    public void setFildaddress(String fildaddress) {
        this.fildaddress = fildaddress == null ? null : fildaddress.trim();
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    public Integer getScore3() {
        return score3;
    }

    public void setScore3(Integer score3) {
        this.score3 = score3;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }
}