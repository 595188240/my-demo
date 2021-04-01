package com.my.demo.strategypattern;

/**
 * Date        Author
 * 2021/4/1     ffdeng
 **/
public class OriginalPrice implements Strategy {

    @Override
    public double price(double pay) {
        return pay;
    }

}
