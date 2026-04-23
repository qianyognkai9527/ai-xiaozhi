package com.joker.ai.xiaozhi.design.simplefactory.v3;

import com.joker.ai.xiaozhi.design.simplefactory.Pizza;

public class ChinaPizza implements Pizza {
    String name="亚洲披萨";
    @Override
    public void prepare() {
                System.out.println(name+"准备");

    }

    @Override
    public void bake() {
        System.out.println(name+"烘烤");

    }

    @Override
    public void cut() {

        System.out.println(name+"切块");
    }

    @Override
    public void box() {

        System.out.println(name+"打包");
    }
}
