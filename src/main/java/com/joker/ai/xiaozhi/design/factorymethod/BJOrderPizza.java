package com.joker.ai.xiaozhi.design.factorymethod;

public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza=null;
        switch (orderType){
            case "cheese":
                pizza=new BJCheesePizza();
                break;
            case "paper":
                pizza=new BJPaperPizza();
                break;
            default:
                break;
        }
        return pizza;
    }
}
