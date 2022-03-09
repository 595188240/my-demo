package com.my.demo.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ffdeng2
 * @date 2022-3-8 13:46
 */
public class T2055 {

    public static void main(String[] args) {
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};
        System.out.println(Arrays.toString(platesBetweenCandles(s, queries)));
        System.out.println(Arrays.toString(platesBetweenCandles2(s, queries)));
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] result = new int[queries.length];
        int index = 0;
        for (int[] querie : queries) {
            int count = 0;
            Stack<Character> stack = new Stack<>();
            for (int i = querie[0]; i <= querie[1]; i++) {
                if (stack.empty()) {
                    if (s.charAt(i) == '|') {
                        stack.push(s.charAt(i));
                    }
                } else {
                    if (s.charAt(i) == '|') {
                        if (stack.peek() == '|') {
                            continue;
                        }
                        count += stack.size() - 1;
                        stack = new Stack<>();
                    }
                    stack.push(s.charAt(i));
                }
            }
            result[index++] = count;
        }
        return result;
    }

    public static int[] platesBetweenCandles2(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        System.out.println(Arrays.toString(preSum));
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]], y = left[query[1]];
            System.out.println(Arrays.toString(query));
            System.out.println(x + " " + y);
            ans[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
        }
        return ans;
    }
}
