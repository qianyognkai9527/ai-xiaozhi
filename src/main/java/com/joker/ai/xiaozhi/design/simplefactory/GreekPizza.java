package com.joker.ai.xiaozhi.design.simplefactory;

public class GreekPizza implements Pizza {

    private String name = "希腊";

    @Override
    public void prepare() {
        System.out.println(name + "准备制作");
    }

    @Override
    public void bake() {
        System.out.println(name + "烘烤中");
    }

    @Override
    public void cut() {
        System.out.println(name + "切块中");
    }

    @Override
    public void box() {

        System.out.println(name + "打包中");
    }
}
