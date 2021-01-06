package com.example.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Properties;

@RestController
public class FileDownLoadController {
    private final String CONTENTTYPE="application/force-download";
    private final String CONTENTDISPOSITION="Content-Disposition";
    private final String ATTACHMENT="attachment;fileName=";
    private final String CHARSETNAME="UTF-8";
    private final String ISOCHARSET="iso-8859-1";
    private final String PATH="/application.properties";
    private final String FILEURL="file.url";


    /**
     * excel表格下载
     *
     * @return
     */

    @GetMapping(value = "/downExcel", produces = "application/json;charset=UTF-8")
    public void downloadFile(HttpServletResponse response) throws IOException {
        //String downloadFilePath = "/root/file/";//被下载的文件在服务器中的路径,
        //String fileName = "销售出库未做运费发票部分.xlsx";//被下载文件的名称
        //String downloadFilePath = "D:\\file\\";//windows目录
        String fileName = "销售出库未做运费发票部分.xlsx";//被下载文件的名称
        Resource resource = new ClassPathResource(PATH);//
        Properties properties = PropertiesLoaderUtils.loadProperties(resource);
        //获取key对应的value值
        String downloadFilePath=properties.getProperty(FILEURL);
        File file = new File(downloadFilePath+fileName);
         if(file.exists()){
        response.setContentType(CONTENTTYPE);// 设置强制下载不打开
        response.addHeader(CONTENTDISPOSITION, ATTACHMENT + new String(fileName.getBytes(CHARSETNAME),ISOCHARSET));
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream outputStream = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                outputStream.write(buffer, 0, i);
                i = bis.read(buffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
}
