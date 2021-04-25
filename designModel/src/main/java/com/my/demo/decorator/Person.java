package com.my.demo.decorator;

/**
 * Date        Author
 * 2021/4/25     ffdeng
 **/
public class Person implements Human {

    @Override
    public void wearClothes() {
        System.out.println("穿什么呢。。");
    }

    @Override
    public void walkToWhere() {
        System.out.println("去哪里呢。。");
    }

    public static void main(String[] args) {
        Person person = new Person();
        Decorator decorator = new DecoratorTwo(new DecoratorOne(
                new DecoratorZero(person)));
        decorator.wearClothes();
        decorator.walkToWhere();
    }
}
