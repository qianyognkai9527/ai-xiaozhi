package com.joker.ai.xiaozhi.design.simplefactory.v4;

import com.joker.ai.xiaozhi.design.simplefactory.Pizza;
import com.joker.ai.xiaozhi.design.simplefactory.v3.PizzaFactory;
import dev.langchain4j.agent.tool.P;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizzaV4 {



    private Pizza pizza;

    public OrderPizzaV4() {
        do {
            String type = getType();
            pizza = PizzaFactory.createPizza(type);
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
