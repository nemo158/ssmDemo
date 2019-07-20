package com.demo.mms.controller;

import com.demo.mms.common.domain.Finalreport;
import com.demo.mms.common.domain.Midreport;
import com.demo.mms.service.FinalreportService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FinalreportController {
    @Autowired
    private FinalreportService finalreportService;

    @RequestMapping(value="/addFinalreport",method= RequestMethod.POST)
    @ResponseBody
    public Object addFinalreport(@RequestBody Finalreport finalreport){
        Integer version = finalreportService.addMaxversion(finalreport.getReporid());
        if(version==null){
            version=0;
        }
        finalreport.setVersion(version+1);
        finalreportService.addFinalreport(finalreport);
        Map<String,Object> rs = new HashMap<>(64);
        rs.put("success",true);
        return rs;
    }
    @RequestMapping("/returnFinalreport")
    @ResponseBody
    public Object returnFinalreport(int report_id){
        Integer version = finalreportService.addMaxversion(report_id);
        Finalreport finalreport= finalreportService.findFinalreport(report_id,version);
        Map<String,Object> rs = new HashMap<>(64);
        rs.put("success",finalreport);
        return rs;
    }
    /**
     * 接收文件上传请求
     */
    @RequestMapping("/saveFinalreport")
    @ResponseBody
    public Object saveFile(List<MultipartFile> items, @Param("student_id")int student_id){
        if(items !=null && items.size()>0){
            Integer version = finalreportService.addMaxversion(student_id);
            if (version==null){
                version=0;
            }
            version++;
            for (MultipartFile item : items) {
                //获取上传文件的原始名称
                String originalFilename = item.getOriginalFilename();

                //设置上传文件的保存地址目录
                String dirPath="D:\\TemFileUpload\\"+student_id+"\\";
                File file =new File(dirPath);
                //如果保存文件的地址不存在，就先创建目录
                if(!file.exists()){
                    file.mkdirs();
                }
                String newFilename= originalFilename;
                String finalpath= dirPath+version+";"+newFilename;
                try {
                    //使用MultipartFile接口的方法完成文件上传到指定位置
                    item.transferTo(new File(finalpath));
                    finalreportService.addFinalreportpath(finalpath,Integer.toString(student_id),Integer.toString(version));
                    System.out.println("1"+finalpath+" "+student_id+" "+version);
                    //文件上传成功后，需要将文件存放路径存入数据库中
                    //TODO,省略
                } catch (Exception e) {
                    e.printStackTrace();
                    //当文件上传出现异常，则重定向到文件上传页面
                    Map<String,Object> rs = new HashMap<>(64);
                    rs.put("success",true);
                    return rs;
                }
            }
        }
        Map<String,Object> rs = new HashMap<>(64);
        rs.put("success",true);
        return rs;
    }
}

