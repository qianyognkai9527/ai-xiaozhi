package com.joker.ai.xiaozhi.design.singleton;


import lombok.SneakyThrows;

/**
 * 1.饿汉式 写法1
 * 直接初始化，如果没有用到，会存在浪费内存的问题
 */
public class SingleTon01 {

    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Single1 single1 = Single1.getSingle1();
                    System.out.println(single1);
                }
            }).start();

        }
    }
}

class Single1{
    //构造器私有化
    private Single1(){

    }

    private static Single1 single1 = new Single1();

    public static Single1 getSingle1(){
        return single1;
    }
}