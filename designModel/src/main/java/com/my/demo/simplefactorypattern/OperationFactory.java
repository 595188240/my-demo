package com.my.demo.simplefactorypattern;

import org.apache.commons.lang3.StringUtils;

/**
 * Date        Author
 * 2021/4/1     ffdeng
 * 简单工厂模式
 **/
public class OperationFactory {

    public static Operation createOperation(String operation) {
        Operation oper = null;
        if (StringUtils.isNotBlank(operation)) {
            switch (operation) {
                case "+" :
                    oper = new OperationAdd();
                    break;
                case "-" :
                    oper = new OperationSub();
                    break;
                case "*" :
                    oper = new OperationMul();
                    break;
                case "/" :
                    oper = new OperationDiv();
                    break;
                default:
                    break;
            }
        }
        return oper;
    }

    public static void main(String[] args) throws Exception {
        Operation operation = OperationFactory.createOperation("*");
        operation.setNumA(111);
        operation.setNumB(222);
        System.out.println(operation.getResult());
    }
}
