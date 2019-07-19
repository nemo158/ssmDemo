package com.demo.mms.controller;

import com.demo.mms.common.domain.*;
import com.demo.mms.service.MidreportService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MidreportController {
    @Autowired
    private MidreportService midreportService;
    @RequestMapping(value="/addMidreport",method= RequestMethod.POST)
    @ResponseBody
    public Object saveMidreport(@RequestBody Midreport midreport){
        Integer integer = midreportService.addMaxversion(midreport.getCourse_id());
        if(integer==null){
            integer=0;
        }
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
    @RequestMapping("/saveFile")
    @ResponseBody
    public class Servlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if (!ServletFileUpload.isMultipartContent(request)) {
                throw new RuntimeException("当前请求不支持文件上传");
            }
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = null;
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            for (FileItem item : items) {
                if(item.isFormField()){//普通表单
                    String fieldName =item.getFieldName();//获取名称
                    String fieldValue =item.getString();//获取值
                    System.out.println(fieldName+""+fieldValue);
                }
                else{//文件表单
                    String fileName =item.getName();
                    InputStream inputStream =item.getInputStream();
                    String path = this.getServletContext().getRealPath("/storage");
                    File descFile = new File(path,fileName);
                    OutputStream outputStream =new FileOutputStream(descFile);
                    int len = -1;
                    byte[] buffer = new byte[10240];
                    while ((len = inputStream.read(buffer))!=-1){
                        outputStream.write(buffer,0,len);
                    }
                    outputStream.close();
                    inputStream.close();;
                }
            }
        }
    }
}