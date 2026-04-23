package com.joker.ai.xiaozhi.design.simplefactory.v1;

import com.joker.ai.xiaozhi.design.simplefactory.CheesePizza;
import com.joker.ai.xiaozhi.design.simplefactory.GreekPizza;
import com.joker.ai.xiaozhi.design.simplefactory.Pizza;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 版本1
 * 优点：编程简单，方便理解
 * 缺点：扩展性差，不能扩展 违反了开闭原则
 */
public class OrderPizzaV1 {
    public static void main(String[] args) {
        new OrderPizzaV1();
    }


    public OrderPizzaV1(){
        Pizza pizza=null;
        String orderType=null;
        do {
            orderType = getType();
            if (StringUtils.equals("greek", orderType)) {
                pizza = new GreekPizza();
            } else if (StringUtils.equals("cheese", orderType)){
                pizza = new CheesePizza();

            }else {
                break;
            }
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }

    private String getType(){

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
