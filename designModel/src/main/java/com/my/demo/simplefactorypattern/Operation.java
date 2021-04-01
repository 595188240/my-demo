package com.my.demo.simplefactorypattern;

/**
 * Date        Author
 * 2021/4/1     ffdeng
 **/
public class Operation {

    private double numA;

    private double numB;

    public double getResult() throws Exception {
        return 0;
    }

    public double getNumA() {
        return numA;
    }

    public void setNumA(double numA) {
        this.numA = numA;
    }

    public double getNumB() {
        return numB;
    }

    public void setNumB(double numB) {
        this.numB = numB;
    }
}
