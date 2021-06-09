package com.my.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ffdeng
 * @date 2021/6/9 16:47
 * 罗马数字转整数
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。

 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class T13 {
    public static void main(String[] args) {
        String str = "LVIII";
        System.out.println(getResult(str));
    }

    public static int getResult(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if (str.length() == 1) {
            return map.get(str);
        }

        char[] arr = str.toCharArray();
        char temp = arr[arr.length - 1];
        int result = map.get(temp);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (map.get(temp) > map.get(arr[i])) {
                result -= map.get(arr[i]);
            } else {
                result += map.get(arr[i]);
            }
            temp = arr[i];
        }

        return result;
    }
}
