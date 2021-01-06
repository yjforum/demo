package com.example.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.apache.poi.ss.formula.functions.T;

/**
 * @description:
 * @author: michael
 * @create: 2020-12-26 12:36
 */

/**
 * 为什么使用内部类：
 * 1、可以无条件地访问外围类的所有元素
 * 2、关于内部类的第二个好处其实很显而易见，我们都知道外部类即普通的类不能使用 private protected 访问权限符来修饰的，而内部类则可以使用 private 和 protected 来修饰。当我们使用 private 来修饰内部类的时候这个类就对外隐藏了。这看起来没什么作用，但是当内部类实现某个接口的时候，在进行向上转型，对外部来说，就完全隐藏了接口的实现了
 * 3、可以实现多重继承类
 * 4、匿名内部类
 * 匿名内部类是没有访问修饰符的。
 * 匿名内部类必须继承一个抽象类或者实现一个接口
 * 匿名内部类中不能存在任何静态成员或方法
 * 匿名内部类是没有构造方法的，因为它没有类名。
 * 与局部内部类相同匿名内部类也可以引用局部变量。此变量也必须声明为 final
 */
@Data
public class Test {
    private int name=2;
    /**
     * static可以修饰变量、类、方法，也可以单独使用（静态代码块）
     */
    private static String sex;
    static double a;
    /**
     * 初始化数据
     */
    static {
        a=22.2;

    }

    private class Test1 implements Test3{
        public  void show(){
            int name1=name;
            System.out.println(name1);
        }
        public void show1(){
            double name2=a;
            System.out.println(name2);
        }

        @Override
        public void innerMethod() {
            System.out.println("0---------------");
        }
    }
    @AllArgsConstructor
    @Getter
    enum Test2{
        code("",""),
        message("","");
        String code1;
        String message1;
    }



    /**
     * abstract:抽象
     */
   abstract interface Test3{
        abstract void innerMethod();
    }
   class Test4 extends Test implements Test3{

       @Override
       public void innerMethod() {

       }
   }
    public static void main(String[] args) {
//      Test1 test1=new Test().new Test1();
//        test1.innerMethod();
       // 测试static静态代码块
  //    Test t=new Test();
       Test1 test1=new Test().new Test1();
        test1.show1();
    }
}
