package com.my.demo.leetcode.medium;

/**
 * @author ffdeng2
 * 灯泡开关
 */
public class T319 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(bulbSwitch(n));
    }

    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }
}
