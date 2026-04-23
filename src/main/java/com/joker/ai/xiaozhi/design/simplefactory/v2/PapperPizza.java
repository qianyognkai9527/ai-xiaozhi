package com.joker.ai.xiaozhi.design.simplefactory.v2;

import com.joker.ai.xiaozhi.design.simplefactory.Pizza;

public class PapperPizza implements Pizza {

    String name="胡椒";
    @Override
    public void prepare() {

        System.out.println("准备"+name+"披萨");
    }

    @Override
    public void bake() {
        System.out.println("烤"+name+"披萨");

    }

    @Override
    public void cut() {

        System.out.println("切"+name+"披萨");

    }

    @Override
    public void box() {
        System.out.println("打包"+name+"披萨");

    }
}
