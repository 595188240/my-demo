package com.my.demo.leetcode;

import java.util.Stack;

/**
 * Date        Author
 * 2021/4/1     ffdeng
 **/
public class T1006 {

    public static void main(String[] args) {
        System.out.println(clumsy(10));
    }

    public static int clumsy(int N) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        stack.push(N);
        for (int i = N - 1; i > 0; i--) {
            if (index == 4) {
                index = 0;
            }
            switch (index) {
                case 0:
                    stack.push(stack.pop() * i);
                    break;
                case 1:
                    stack.push(stack.pop() / i);
                    break;
                case 2:
                    stack.push(i);
                    break;
                case 3:
                    stack.push(-i);
                    break;
                default:
                    break;
            }
            index++;
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
