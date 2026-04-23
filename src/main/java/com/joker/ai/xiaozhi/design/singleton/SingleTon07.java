package com.joker.ai.xiaozhi.design.singleton;

import java.util.stream.IntStream;

public class SingleTon07 {

    public static void main(String[] args) {
        IntStream.range(0,20).forEach(i -> {
                    System.out.println(String.format("%02d",i)+":"+Single.INSTANCE.hashCode());
                }
        );
        //Runtime类就是 单例模式的 饿汉式写法
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("程序关闭了");
            }
        }));
    }


}

enum Single{
    INSTANCE;

    public void sayOk(){
        System.out.println("hello world");
    }
}

