package com.joker.ai.xiaozhi.design.simplefactory.v3;

public class PizzaStore {

    public static void main(String[] args) {
        new OrderPizzaV3(new PizzaFactory());
    }
}
