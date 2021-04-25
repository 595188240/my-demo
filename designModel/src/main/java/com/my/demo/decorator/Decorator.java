package com.my.demo.decorator;

/**
 * Date        Author
 * 2021/4/25     ffdeng
 **/
//定义装饰者
public abstract class Decorator implements Human {

    private Human human;

    public Decorator(Human human) {
        this.human = human;
    }

    @Override
    public void wearClothes() {
        human.wearClothes();
    }

    @Override
    public void walkToWhere() {
        human.walkToWhere();
    }

}
