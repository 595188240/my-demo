package com.my.demo.leetcode.array.medium;

/**
 * @author ffdeng2
 */
public class T38 {

    public static void main(String[] args) {
        int n = 6;
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {
        String result = "1";
        if (n == 1) {
            return result;
        }
        for (int i = 1; i < n ; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = result.toCharArray();
            int count = 1;
            char c = chars[0];
            for (int j = 1; j < chars.length; j++) {
                if (c == chars[j]) {
                    count++;
                } else {
                    stringBuilder.append(count);
                    stringBuilder.append(c);
                    c = chars[j];
                    count = 1;
                }
            }
            if (c == chars[chars.length - 1]) {
                stringBuilder.append(count);
                stringBuilder.append(c);
            }
            result = stringBuilder.toString();
        }
        return result;
    }

}
