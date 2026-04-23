package com.joker.ai.xiaozhi.design.simplefactory;

public class CheesePizza implements Pizza {

    private String name="奶酪pizza";
    @Override
    public void prepare() {
        System.out.println(name+"准备制作");

    }

    @Override
    public void bake() {
        System.out.println(name+"红莲中");

    }

    @Override
    public void cut() {
        System.out.println(name+"切块中");

    }

    @Override
    public void box() {
        System.out.println(name+"打包中");

    }
}
