package com.my.demo.singleton;

/**
 * Date        Author
 * 2021/5/11     ffdeng
 * 懒汉 双重检测锁机制
 **/
public class DDLSingleton {

    private DDLSingleton() {}

    private volatile static DDLSingleton ddlSingleton;

    public static DDLSingleton getInstance() {
        if (ddlSingleton == null) {
            synchronized (DDLSingleton.class) {
                if (ddlSingleton == null) {
                    ddlSingleton = new DDLSingleton();
                }
            }
        }
        return ddlSingleton;
    }

}
