package com.my.demo.decorator;

/**
 * Date        Author
 * 2021/4/25     ffdeng
 **/
public class DecoratorZero extends Decorator {

    public DecoratorZero(Human human) {
        super(human);
    }

    public void goHome() {
        System.out.println("皮鞋");
    }

    public void findMap() {
        System.out.println("合肥");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        goHome();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findMap();
    }
}
