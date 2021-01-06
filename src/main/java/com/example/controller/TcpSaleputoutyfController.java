package com.example.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.example.entity.TcpSaleputoutyf;
import com.example.listener.ExcelListener;
import com.example.service.TcpSaleputoutyfService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@RestController
public class TcpSaleputoutyfController {
    @Resource
    private TcpSaleputoutyfService tcpSaleputoutyfService;
    @PostMapping("/import")
    public String importFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception{

        if (file.isEmpty()) {
            return "上传文件不能为空";
        }
        ExcelReader excelReader=null;
        try {
           EasyExcel.read(file.getInputStream(), TcpSaleputoutyf.class, new ExcelListener(tcpSaleputoutyfService,request)).sheet().doRead();
            System.out.println("==========");
        } catch (IOException e) {
            return "导入失败";
        }finally {
            if (excelReader != null) {
                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
                excelReader.finish();
            }
        }

        return "导入成功";

    }
}
