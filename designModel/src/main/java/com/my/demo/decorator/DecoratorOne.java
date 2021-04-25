package com.my.demo.decorator;

/**
 * Date        Author
 * 2021/4/25     ffdeng
 **/
public class DecoratorOne extends Decorator {

    public DecoratorOne(Human human) {
        super(human);
    }

    public void findClothes() {
        System.out.println("西服");
    }

    public void findTheTarget() {
        System.out.println("青岛");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        findClothes();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findTheTarget();
    }

}
