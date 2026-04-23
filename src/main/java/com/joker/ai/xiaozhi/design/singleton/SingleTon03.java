package com.joker.ai.xiaozhi.design.singleton;

import java.util.stream.IntStream;

/**
 * 懒汉式写法1
 *  存在线程安全问题
 *  不推荐使用！！！！！
 */
public class SingleTon03 {

    public static void main(String[] args) {
        IntStream.range(0,10).forEach(i -> {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    Single3 single3 = Single3.getSingle3();
                    System.out.println(i +
                            ": "+single3);
                }
            }).start();
        });
    }
}


class Single3{
    private static Single3 single3;
    private Single3(){

    }
    public static Single3 getSingle3(){
        if(single3 == null){
            single3 = new Single3();
        }
        return single3;
    }
}