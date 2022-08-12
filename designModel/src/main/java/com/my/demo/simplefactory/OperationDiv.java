package com.my.demo.simplefactory;

/**
 * Date        Author
 * 2021/4/1     ffdeng
 **/
public class OperationDiv extends Operation {

    @Override
    public double getResult() throws Exception {
        if (getNumB() == 0) {
            throw new Exception("被除数不能为0！");
        }
        return getNumA() / getNumB();
    }

}
