package com.joker.ai.xiaozhi.design.singleton;


import java.util.Objects;
import java.util.stream.IntStream;

/**
 * 5.懒汉式写法3
 *  双重检查 + 细粒度同步锁
 *  保证性能，线程安全
 *
 *  推荐使用
 */
public class SingleTon05 {
    public static void main(String[] args) {
        IntStream.range(0,20).forEach(i -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Single5 singleTon5 = Single5.getSingleTon5();
                    System.out.println(String.format("线程%02d",i)+":"+singleTon5);
                }
            }).start();
        });
    }
}

class Single5 {
    private static Single5 singleTon5;
    private Single5(){}
    public static Single5 getSingleTon5(){
        if (singleTon5 == null){
            synchronized (Single5.class){
                if(Objects.isNull(singleTon5)){
                    singleTon5 = new Single5();
                }
            }

        }
        return singleTon5;
    }
}