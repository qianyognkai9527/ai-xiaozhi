package com.joker.ai.xiaozhi.design.simplefactory.v3;

import com.joker.ai.xiaozhi.design.simplefactory.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizzaV3 {


    private PizzaFactory pizzaFactory;
    private Pizza pizza;
    public void setPizzaFactory(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
        do {
            String type = getType();
            pizza = this.pizzaFactory.createPizza(type);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                break;
            }
        }while ( true);
    }

    public OrderPizzaV3(PizzaFactory pizzaFactory) {
        setPizzaFactory(pizzaFactory);
    }

    public static String getType() {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            System.out.println("请输入pizza类型：");
            String orderType = bufferedReader.readLine();
            return orderType;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
