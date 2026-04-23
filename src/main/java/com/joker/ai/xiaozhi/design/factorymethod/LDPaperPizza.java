package com.joker.ai.xiaozhi.design.factorymethod;

public class LDPaperPizza implements Pizza {

    String name = "伦敦胡椒披萨";

    @Override
    public void prepare() {
        System.out.println("伦敦胡椒披萨准备");

    }

    @Override
    public void bake() {

        System.out.println("伦敦胡椒披萨烘烤");
    }

    @Override
    public void cut() {
        System.out.println("伦敦胡椒披萨切割");

    }

    @Override
    public void box() {
        System.out.println("伦敦胡椒披萨打包");

    }
}
