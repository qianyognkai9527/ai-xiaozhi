package com.joker.ai.xiaozhi.design.absfactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakePizza {

    private AbsFactory absFactory;

    public MakePizza(AbsFactory absFactory) {
        setAbsFactory(absFactory);
    }

    private void setAbsFactory(AbsFactory absFactory) {
        this.absFactory = absFactory;
        Pizza pizza = null;
        do{
            String type=getType();
            pizza = absFactory.createPizza(type);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                break;
            }

        }while (true);

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
