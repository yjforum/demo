package com.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:
 * @author: michael
 * @create: 2020-12-26 12:12
 */
@Getter
@AllArgsConstructor
public enum RsponseType {
    CODE(200,"状态吗",""),
    NAME(100,"状态吗1","");
    Integer code;
    String message;
    String status;




    public static void main(String[] args) {
        System.out.println(RsponseType.CODE.getMessage()+RsponseType.NAME.getCode());
    }
}
