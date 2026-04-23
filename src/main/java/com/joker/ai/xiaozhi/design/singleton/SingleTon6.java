package com.joker.ai.xiaozhi.design.singleton;

import java.util.stream.IntStream;

/**
 * 静态内部类写法
 * 线程安全
 * 推荐使用
 */
public class SingleTon6 {

    public static class Single6{
        private static final SingleTon6 singleTon6=new SingleTon6();

    }
    public static synchronized SingleTon6 getSingleTon6(){
        return Single6.singleTon6;
    }
    public static void main(String[] args) {
        IntStream.range(0,20).forEach(i -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingleTon6 singleTon6 = SingleTon6.getSingleTon6();
                    System.out.println(String.format("%02d", i)+": "+singleTon6);
                }
            }).start();
        });
    }
}




