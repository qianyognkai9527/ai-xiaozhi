package com.joker.ai.xiaozhi.design.absfactory;

public class BJFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
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
