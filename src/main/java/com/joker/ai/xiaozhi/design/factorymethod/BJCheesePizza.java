package com.joker.ai.xiaozhi.design.factorymethod;

public class BJCheesePizza implements Pizza{

    String name="北京的奶酪披萨";
    @Override
    public void prepare() {

        System.out.println("给北京的奶酪披萨准备原材料");
    }

    @Override
    public void bake() {
        System.out.println("给北京的奶酪披萨准备原材料");

    }

    @Override
    public void cut() {
        System.out.println("给北京的奶酪披萨准备原材料");

    }

    @Override
    public void box() {

        System.out.println("给北京的奶酪披萨准备原材料");
    }
}
