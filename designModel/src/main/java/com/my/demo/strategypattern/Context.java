package com.my.demo.strategypattern;

/**
 * Date        Author
 * 2021/4/1     ffdeng
 * 策略模式
 **/
public class Context {

    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void pringPrice(double s){
        System.out.println("您需支付：" + strategy.price(s) + "元");
    }

    public static void main(String[] args) {
        NineDiscount nineDiscount = new NineDiscount();
        Context context = new Context(nineDiscount);
        context.pringPrice(500);
    }

}
