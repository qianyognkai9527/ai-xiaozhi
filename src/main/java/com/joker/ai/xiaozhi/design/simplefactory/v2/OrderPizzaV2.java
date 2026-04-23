package com.joker.ai.xiaozhi.design.simplefactory.v2;

import com.joker.ai.xiaozhi.design.simplefactory.CheesePizza;
import com.joker.ai.xiaozhi.design.simplefactory.GreekPizza;
import com.joker.ai.xiaozhi.design.simplefactory.Pizza;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 版本2
 * 新增以恶搞胡椒披萨就要改动代码
 */
public class OrderPizzaV2 {
    public static void main(String[] args) {
        new OrderPizzaV2();
    }


    public OrderPizzaV2(){
        Pizza pizza=null;
        String orderType=null;
        do {
            orderType = getType();
            if (StringUtils.equals("greek", orderType)) {
                pizza = new GreekPizza();
            } else if (StringUtils.equals("cheese", orderType)) {
                pizza = new CheesePizza();
            } else if (StringUtils.equals("papper", orderType)) {
                pizza = new PapperPizza();
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
