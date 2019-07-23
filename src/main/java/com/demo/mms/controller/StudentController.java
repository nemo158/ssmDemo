package com.demo.mms.controller;

import com.demo.mms.common.domain.Student;
import com.demo.mms.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private courseService courseService;
//    private  CourseService courseService;

    @RequestMapping("/checkUserName")
    @ResponseBody
    public boolean checkUserName(int usr){ return studentService.checkUserName(usr); }

    @RequestMapping("/checkUsrANDPwd")
    @ResponseBody
    public Object checkUsrANDPwd(@Param("usr") Integer usr, @Param("pwd") String pwd, HttpSession session){
        String msg=null;
        Map<String,Object> rs = new HashMap<>(64);
        if(studentService.checkUsrANDPwd(usr,pwd)){
           msg="登录成功";
            rs.put("msg",msg);
            session.setAttribute("current_user",usr);
        }else{
            msg="用户名或密码错误";
            rs.put("msg",msg);
        }
        return rs;

    }

    @RequestMapping("/getUser")
    @ResponseBody
    public Object getUser(HttpSession session){
        Integer currentUser = (Integer) session.getAttribute("current_user");
        course coursetl= courseService.findcourse(currentUser);
        Map<String,Object>rs = new HashMap<>(64);
        if(currentUser!=null){
            rs.put("current_user",currentUser);
            rs.put("course_id",coursetl.getId());
            return rs;
        }
        return  null;

    }

/*    @RequestMapping("fetchThePassword")
    @ResponseBody
    public */
    /*@RequestMapping("/getStudentInformation")
    @ResponseBody
    public Object getStudentInformation(int stuId){
        Course course=courseService.getCourse(stuId);//在course中实现
//        return studentService.getStudent(stuId);
    }
*/
}
