package com.joker.ai.xiaozhi.design.simplefactory.v3;

/**
 * 简单工厂模式
 */
public class PizzaStore {

    public static void main(String[] args) {
        new OrderPizzaV3(new PizzaFactory());
    }
}
