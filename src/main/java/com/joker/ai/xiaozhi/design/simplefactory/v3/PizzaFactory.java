package com.joker.ai.xiaozhi.design.simplefactory.v3;

import com.joker.ai.xiaozhi.design.simplefactory.CheesePizza;
import com.joker.ai.xiaozhi.design.simplefactory.GreekPizza;
import com.joker.ai.xiaozhi.design.simplefactory.Pizza;
import com.joker.ai.xiaozhi.design.simplefactory.v2.PapperPizza;
import org.apache.commons.lang.StringUtils;

public class PizzaFactory {

    public static Pizza createPizza(String orderType) {
        System.out.println("使用简单工厂模式");
        Pizza pizza = null;
        do {

            if (StringUtils.equals("greek", orderType)) {
                pizza = new GreekPizza();
            } else if (StringUtils.equals("cheese", orderType)) {
                pizza = new CheesePizza();
            } else if (StringUtils.equals("china", orderType)) {
                pizza = new ChinaPizza();
            } else if (StringUtils.equals("papper", orderType)) {
                pizza = new PapperPizza();
            } else {
                break;
            }
            return pizza;
        } while (true);
        return pizza;
    }





}
