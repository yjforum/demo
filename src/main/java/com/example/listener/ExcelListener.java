package com.example.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.example.entity.TcpSaleputoutyf;
import com.example.service.TcpSaleputoutyfService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class ExcelListener extends AnalysisEventListener<TcpSaleputoutyf> {
    /**
     * 批处理阈值,每200000条保存一次数据库
     */
    private static final int BATCH_COUNT = 200000;
    List<TcpSaleputoutyf> list = new ArrayList<>(BATCH_COUNT);
    // 业务层service
    private TcpSaleputoutyfService tcpSaleputoutyfService;
    private HttpServletRequest request;

    public ExcelListener(){

    }

    public ExcelListener(TcpSaleputoutyfService tcpSaleputoutyfService, HttpServletRequest request){
        this.tcpSaleputoutyfService = tcpSaleputoutyfService;
        this.request = request;
    }
    @Override
    public void invoke(TcpSaleputoutyf tcpSaleputoutyf, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(tcpSaleputoutyf));
        list.add(tcpSaleputoutyf);
        if (list.size() >= BATCH_COUNT){
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.debug("所有数据解析完成！");
    }
    private void saveData(){
        // 调用业务层保存数据
        tcpSaleputoutyfService.insertSalePutoutYF(list);
        log.debug("{}条数据，开始存储数据库！", list.size());
        log.debug("存储数据库成功！");
    }
}
