package com.my.demo.singleton;

/**
 * Date        Author
 * 2021/5/11     ffdeng
 * 单例枚举 线程安全
 * JVM会保证枚举类中的构造方法只调用一次，因此使用枚举会保证只实例化一次。
 **/
public class EnumSingleton {

    private EnumSingleton() {}

    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {

        INSTANCE,
        ;

        private EnumSingleton enumSingleton;

        Singleton() {
            enumSingleton = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return enumSingleton;
        }
    }

}
