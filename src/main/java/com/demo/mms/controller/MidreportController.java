package com.demo.mms.controller;

import com.demo.mms.common.domain.*;
import com.demo.mms.service.MidreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MidreportController {
    @Autowired
    private MidreportService midreportService;
    @RequestMapping(value="/addMidreport",method= RequestMethod.POST)
    @ResponseBody
    public Object saveMidreport(@RequestBody Midreport midreport){
        Integer integer = midreportService.addMaxversion(midreport.getCourse_id());
        midreport.setVersion(integer+1);
        midreportService.addMidreport(midreport);
        Map<String,Object> rs = new HashMap<>(64);
        rs.put("success",true);
        return rs;
    }
    @RequestMapping("/returnMidreport")
    @ResponseBody
    public Object returnMidreport(int course_id){
        Integer version = midreportService.addMaxversion(course_id);
        Midreport midreport1= midreportService.findreport(course_id,version);
        Map<String,Object> rs = new HashMap<>(64);
        rs.put("success",midreport1);
        return rs;
    }
}