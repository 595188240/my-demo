package com.my.deom;

/**
 * @author ffdeng2
 * @date 2022-6-10 16:14
 */
public class SyncClass {

    public static void main(String[] args) {
        SyncClass syncClass = new SyncClass();
        syncClass.test();
    }

    public synchronized void test() {
        System.out.println("qwer");
    }
}
