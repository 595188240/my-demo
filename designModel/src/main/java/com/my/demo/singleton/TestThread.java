package com.my.demo.singleton;

/**
 * Licensed to CMIM,Inc. under the terms of the CMIM
 * Software License version 1.0.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date        Author        Version        Comments
 * 2021/5/11     ffdeng         1.0       Initial Version
 **/
public class TestThread extends Thread {

    @Override
    public void run() {
//        System.out.println(DDLSingleton.getInstance().hashCode());
//        System.out.println(EnumSingleton.getInstance().hashCode());
        System.out.println(Singleton.getInstance().hashCode());
    }

    public static void main(String[] args) {
        TestThread[] testThread = new TestThread[10];
        for (int i = 0; i < testThread.length; i++) {
            testThread[i] = new TestThread();
        }
        for (int i = 0; i < testThread.length; i++) {
            testThread[i].start();
        }
    }

}
