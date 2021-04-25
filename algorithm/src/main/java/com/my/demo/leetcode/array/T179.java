package com.my.demo.leetcode.array;

import java.util.Arrays;

/**
 * Date        Author        Version        Comments
 * 2021/4/12     ffdeng         1.0       Initial Version
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 **/
public class T179 {

    public static void main(String[] args) {
            int[] nums = {10,2,9,39,17};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        StringBuffer stringBuffer = new StringBuffer();
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(result, (a, b) -> {
            String strA = a + b;
            String strB = b + a;
            return strA.compareTo(strB);
        });
        for (int i = result.length - 1; i >= 0; i--) {
            stringBuffer.append(result[i]);
        }
        // {0,0}
        int k = 0;
        while (k < result.length - 1 && stringBuffer.charAt(k) == '0') {
            k++;
        }
        return stringBuffer.substring(k);
    }

}
