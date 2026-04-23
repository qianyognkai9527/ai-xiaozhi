package com.joker.ai.xiaozhi.design.absfactory;

import com.joker.ai.xiaozhi.design.absfactory.Pizza;

public class BJPaperPizza implements Pizza {

    String name="北京胡椒披萨";
    @Override
    public void prepare() {
        System.out.println(name+"准备制作");
    }

    @Override
    public void bake() {
        System.out.println(name+"准备烤");

    }

    @Override
    public void cut() {
        System.out.println(name+"准备切");

    }

    @Override
    public void box() {
        System.out.println(name+"准备打包");

    }
}
