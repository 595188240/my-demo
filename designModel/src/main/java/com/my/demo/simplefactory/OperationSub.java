package com.my.demo.simplefactory;

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
