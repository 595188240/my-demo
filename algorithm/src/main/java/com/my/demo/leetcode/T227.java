package com.my.demo.leetcode;

import java.util.Stack;

/**
 * Date        Author        Version        Comments
 * 2021/3/15     ffdeng         1.0       Initial Version
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 **/
public class T227 {

    public static void main(String[] args) {
        String s = " 3/2";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        // 将第一个数字放入栈中，然后记录后续符号
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            if (Character.isDigit(temp)) {
                num = num * 10 + temp - '0';
            }
            if (!Character.isDigit(temp) && temp != ' ' || i == chars.length - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                // 记录上一个符号
                preSign = temp;
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
