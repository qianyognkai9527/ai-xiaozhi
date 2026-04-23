package com.joker.ai.xiaozhi.design.factorymethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class OrderPizza {





    abstract Pizza createPizza(String orderType);

    public OrderPizza() {
        do {
            String type = getType();
            Pizza pizza = createPizza(type);
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
