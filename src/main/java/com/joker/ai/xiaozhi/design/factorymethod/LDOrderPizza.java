package com.joker.ai.xiaozhi.design.factorymethod;

public class LDOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {

        Pizza pizza=null;
        switch (orderType){
            case "cheese":
                pizza=new LDCheesePizza();
                break;
            case "paper":
                pizza=new LDPaperPizza();
                break;
            default:
                break;
        }

        return pizza;
    }
}
