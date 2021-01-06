package com.example.service.impl;

import com.example.entity.TcpSaleputoutyf;
import com.example.mapper.TcpSaleputoutyfMapper;
import com.example.service.TcpSaleputoutyfService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TcpSaleputoutyfServiceImpl implements TcpSaleputoutyfService {
    @Resource
    private TcpSaleputoutyfMapper tcpSaleputoutyfMapper;
    @Override
    public int insertSalePutoutYF(List<TcpSaleputoutyf> list) {
        return tcpSaleputoutyfMapper.insertSalePutoutYF(list);
    }
}
