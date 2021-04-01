package com.my.demo.simplefactorypattern;

/**
 * Date        Author
 * 2021/4/1     ffdeng
 **/
public class OperationSub extends Operation {

    @Override
    public double getResult() {
        return getNumA() - getNumB();
    }

}
