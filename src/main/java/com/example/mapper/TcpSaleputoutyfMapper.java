package com.example.mapper;

import com.example.entity.TcpSaleputoutyf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TcpSaleputoutyfMapper {
    int insertSalePutoutYF(List<TcpSaleputoutyf> list);
}
