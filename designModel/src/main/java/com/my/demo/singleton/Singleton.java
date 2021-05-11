package com.my.demo.singleton;

/**
 * Date        Author
 * 2021/5/11     ffdeng
 * 饿汉单例
 **/
public class Singleton {

    private Singleton() {}

    private static Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }

}
