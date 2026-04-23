package com.joker.ai.xiaozhi.design.singleton;

import java.util.stream.IntStream;

/**
 * 4.懒汉式单例写法2
 * 使用synchronized解决了线程安全问题
 * 但是性能变差了
 * 不推荐使用
 */
public class SingleTon04 {

    public static void main(String[] args) {
        IntStream.range(0,20).forEach(i -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Single4 single4 = Single4.getSingle4();
                    System.out.println(String.format("线程%02d",i)+": "+single4);
                }
            }).start();
        });
    }
}

class Single4{

    private static Single4 single4;
    private Single4(){

    }
    public static synchronized Single4 getSingle4(){
        if(single4 == null){
            single4 = new Single4();
        }
        return single4;
    }
}
