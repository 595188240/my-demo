package com.test.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author ffdeng2
 * @date 2022-6-14 9:22
 */
public class MarkWord {

    public static void main(String[] args) throws InterruptedException {
        UnLock unLock = new UnLock();
        //System.out.println(ClassLayout.parseInstance(unLock).toPrintable());
        //synchronized (unLock) {
            System.out.println(ClassLayout.parseInstance(unLock).toPrintable());
            System.out.println(unLock.hashCode());
            System.out.println(ClassLayout.parseInstance(unLock).toPrintable());
        //}
    }

}
