package com.joker.ai.xiaozhi.design.absfactory;

public class PizzaStore {

    public static void main(String[] args) {
//        new MakePizza(new BJFactory());
        new MakePizza(new LDFactory());
    }
}
