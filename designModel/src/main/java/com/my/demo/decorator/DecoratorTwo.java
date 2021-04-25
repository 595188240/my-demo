package com.my.demo.decorator;

/**
 * Date        Author
 * 2021/4/25     ffdeng
 **/
public class DecoratorTwo extends Decorator {

    public DecoratorTwo(Human human) {
        super(human);
    }

    public void goClothespress() {
        System.out.println("礼帽");
    }

    public void findPlaceOnMap() {
        System.out.println("南京");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        goClothespress();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findPlaceOnMap();
    }

}
