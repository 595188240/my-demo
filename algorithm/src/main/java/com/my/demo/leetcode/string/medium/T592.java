package com.my.demo.leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ffdeng2
 * @date 2022-7-27 17:00
 */
public class T592 {

    public static void main(String[] args) {
        String expression = "-5/2+10/3+7/9";
        System.out.println(fractionAddition(expression));
    }

    public static String fractionAddition(String expression) {
        Boolean ff = false;
        Boolean ss = true;
        List<Integer> zi = new ArrayList<>();
        List<Integer> mu = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '-') {
                ff = true;
                ss = true;
            } else if (c == '+') {
                ff = false;
                ss = true;
            } else if (c == '/') {
                ss = false;
                ff = false;
            } else if (c == '0') {
                if (ss) {
                    zi.set(zi.size() - 1, zi.get(zi.size() - 1) * 10);
                } else {
                    mu.set(mu.size() - 1, mu.get(mu.size() - 1) * 10);
                }
            } else {
                if (ss) {
                    zi.add(ff ? -(c - '0') : c - '0');
                } else {
                    mu.add(ff ? -(c - '0') : c - '0');
                }
            }
        }
        System.out.println(zi);
        System.out.println(mu);
        Integer integer = mu.stream().distinct().reduce((x, y) -> x * y).get();
        List<Integer> zii = new ArrayList<>();
        for (int i = 0; i < mu.size(); i++) {
            int b = integer / mu.get(i);
            zii.add(zi.get(i) * b);
        }
        int ziii = 0;
        for (int i : zii) {
            ziii += i;
        }
        Integer gcb = gcb(integer, Math.abs(ziii));
        return ziii / gcb + "/" + (integer / gcb);
    }

    public static Integer gcb(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcb(b, a - a / b * b);
    }

}
