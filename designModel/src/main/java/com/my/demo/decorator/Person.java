package com.my.demo.decorator;

/**
 * Date        Author        Version        Comments
 * 2021/4/16     ffdeng         1.0       Initial Version
 *装饰模式
 **/
public class Person {

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void Show() {
        System.out.print("装扮的" + name);
    }

    public static void main(String[] args) {
        Person person = new Person("小李");
        System.out.println("第一种装饰");

        TShirts tShirts = new TShirts();
        tShirts.Decorate(person);
        tShirts.Show();

        System.out.println();
        System.out.println("第二种装饰");
        BigTrouser bigTrouser = new BigTrouser();
        bigTrouser.Decorate(person);
        bigTrouser.Show();

    }
}
