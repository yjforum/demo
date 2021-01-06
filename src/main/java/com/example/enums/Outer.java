package com.example.enums;

import lombok.Data;

/**
 * @description:
 * @author: michael
 * @create: 2020-12-26 16:44
 */

public class Outer {

    private static int id=18;
    public void out(){
        System.out.println("这是外部类");
    }

   class Inner{
        public void in(){
            System.out.println("这是内部类");
        }

        public void getID() {
            System.out.println(id);
        }
    }


    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner =outer.new Inner();
        inner.getID();
        outer.out();
        inner.in();
    }


}
