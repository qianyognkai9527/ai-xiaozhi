package com.joker.ai.xiaozhi.design.singleton;

/**
 * 2.懒汉式写法2
 *  在静态代码块里初始化
 *  缺点是 有可能会造成内存浪费
 */
public class SingleTon02 {

    public static void main(String[] args) {
        for (int i = 0; i <10; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Single2 single2 = Single2.getSingle2();
                    System.out.println(single2);
                }
            }).start();
        }
    }
}


class Single2{
    //构造器私有化
    private static Single2 single2;

    //构造器私有化
    private Single2(){
    }

    static {
        single2 = new Single2();
    }
    public static Single2 getSingle2(){
        return single2;
    }
}