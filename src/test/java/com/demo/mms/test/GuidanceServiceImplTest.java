package com.demo.mms.test;

import com.demo.mms.common.domain.Guidance;
import com.demo.mms.service.GuidanceServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GuidanceServiceImplTest {
    public GuidanceServiceImpl gc;

    @Before
    public void setUp() throws Exception {
        gc=new GuidanceServiceImpl();
    }

    @Test
    public void addGuidanceTest() {
//        List<Guidance> testAdd = new ArrayList<>();
        for(int i=0;i<20;i++){
            Guidance temp=new Guidance();
            temp.setId(12345+i);
            temp.setCourseId(11000);
            temp.setVersion(i);
            temp.setContent("This is just a test case content!");
            Date dt=new Date(0);
            temp.setSubmitTime(dt);
            temp.setTime(dt);
//            testAdd.add(temp);
            gc.addGuidance(temp);
        }
//        System.out.println(testAdd.get(1).getContent());
//        gc.addGuidance(testAdd.get(1));
    }

    @Test
    public void getGuidance() {
        for(int i=0;i<20;i++){
            Guidance temp=gc.getGuidance(11000,i);
            System.out.println(temp.getId());
        }
    }

    @Test
    public void selectGuidances() {
        List<Guidance> temp=gc.selectGuidances(11000);
        Iterator hh=temp.iterator();
        while (hh.hasNext()){
            Guidance gg= (Guidance) hh.next();
            System.out.println(gg.getId());
        }
    }

}