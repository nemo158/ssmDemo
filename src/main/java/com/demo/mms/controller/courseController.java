package com.demo.mms.controller;


import com.demo.mms.common.domain.course;
import com.demo.mms.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


@Controller
public class courseController {
    @Autowired
    private courseService courseService;
    @RequestMapping("/getCourse")
    @ResponseBody
    public Object returnCourse(int student_id){
        course coursetl=courseService.findcourse(student_id);
        Map<String,Object>rs = new HashMap<>(64);
        Object success = (Object) rs.put("success", coursetl);
        return rs;
    }
}
