package com.my.demo.strategy;

/**
 * Date        Author
 * 2021/4/1     ffdeng
 * （1）抽象策略角色[Strategy]：策略类，定义了一个公共接口，各种不同的算法以不同的方式实现这个接口，
 * Context使用这个接口调用不同的算法，一般使用接口或抽象类实现。
 * （2）具体策略类[ConcreteStrategy]：实现了Strategy定义的接口，包装了相关的算法和行为，提供具体的算法实现。
 * （3）上下文角色[Context]：持有一个策略类的引用，最终给客户端调用。
 *  ①需要使用ConcreteStrategy提供的算法。
 *  ②内部维护一个Strategy的实例。
 *  ③负责动态设置运行时Strategy具体的实现算法。
 *  ④负责跟Strategy之间的交互和数据传递。
 **/
public interface Strategy {

    double price(double pay);

}
