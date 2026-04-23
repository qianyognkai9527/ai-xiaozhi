package com.joker.ai.xiaozhi.design.absfactory;

public class LDFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
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
