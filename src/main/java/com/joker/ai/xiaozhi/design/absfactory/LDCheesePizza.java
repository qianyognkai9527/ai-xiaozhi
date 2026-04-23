package com.joker.ai.xiaozhi.design.absfactory;

public class LDCheesePizza implements Pizza {

    String name = "伦敦奶酪披萨";

    @Override
    public void prepare() {

        System.out.println("伦敦奶酪披萨准备");
    }

    @Override
    public void bake() {
        System.out.println("伦敦奶酪披萨烘烤");

    }

    @Override
    public void cut() {
        System.out.println("伦敦奶酪披萨切块");

    }

    @Override
    public void box() {
        System.out.println("伦敦奶酪披萨打包");

    }
}
