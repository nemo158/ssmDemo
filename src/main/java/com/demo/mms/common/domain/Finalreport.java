package com.demo.mms.common.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Finalreport {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private int reporid;
    private int studentid;
    private String fileadress;
    private int score1;
    private int score2;
    private int score3;
    private String advice;
    private Date comment_time;
    private String rpeortname;
    private String state;
    private String keyword;
    private String innovation_point;
    private String chinese_abstract;
    private String english_abstract;
    private String others;
    private String detection_result;
    private String report_adress;
    private String result_adress;
    private String enclosure_adress;
    private int version;

    public void setVersion(int version) {
        this.version = version;
    }

    public void setReporid(int reporid) {
        this.reporid = reporid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public void setFileadress(String fileadress) {
        this.fileadress = fileadress;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }

    public void setRpeortname(String rpeortname) {
        this.rpeortname = rpeortname;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setInnovation_point(String innovation_point) {
        this.innovation_point = innovation_point;
    }

    public void setChinese_abstract(String chinese_abstract) {
        this.chinese_abstract = chinese_abstract;
    }

    public void setEnglish_abstract(String english_abstract) {
        this.english_abstract = english_abstract;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public void setDetection_result(String detection_result) {
        this.detection_result = detection_result;
    }

    public void setReport_adress(String report_adress) {
        this.report_adress = report_adress;
    }

    public void setResult_adress(String result_adress) {
        this.result_adress = result_adress;
    }

    public void setEnclosure_adress(String enclosure_adress) {
        this.enclosure_adress = enclosure_adress;
    }

    public int getReporid() {
        return reporid;
    }

    public int getStudentid() {
        return studentid;
    }

    public String getFileadress() {
        return fileadress;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public int getScore3() {
        return score3;
    }

    public String getAdvice() {
        return advice;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public String getRpeortname() {
        return rpeortname;
    }

    public String getState() {
        return state;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getInnovation_point() {
        return innovation_point;
    }

    public String getChinese_abstract() {
        return chinese_abstract;
    }

    public String getEnglish_abstract() {
        return english_abstract;
    }

    public String getOthers() {
        return others;
    }

    public String getDetection_result() {
        return detection_result;
    }

    public String getReport_adress() {
        return report_adress;
    }

    public String getResult_adress() {
        return result_adress;
    }

    public String getEnclosure_adress() {
        return enclosure_adress;
    }

    public int getVersion() {
        return version;
    }
}
