package com.demo.mms.common.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemHeaders;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class Servlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("1");
        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new RuntimeException("当前请求不支持文件上传");
        }
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            System.out.println("2");
            System.out.println(items.size());
            for (FileItem item : items) {
                if(item.isFormField()){//普通表单
                    System.out.println("6");
                    String fieldName =item.getFieldName();//获取名称
                    String fieldValue =item.getString();//获取值
                    System.out.println(fieldName+""+fieldValue);
                }
                else{//文件表单
                    System.out.println("5");
                    String fileName =item.getName();
                    InputStream inputStream =item.getInputStream();
                    //String path = this.getServletContext().getRealPath("/storage");
                    String path="D:\\";
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
            System.out.println("3");
        }
        catch (FileUploadException e){
            e.printStackTrace();
        }
        System.out.println("4");
    }
}
