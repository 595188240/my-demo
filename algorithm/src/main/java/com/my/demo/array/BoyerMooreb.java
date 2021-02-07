package com.my.demo.array;

/**
 * Date        Author
 * 2021/2/6     ffdeng
 *
 * 多数投票算法(Boyer-Moore Algorithm)
 * 查找输入中重复出现超过一半以上(n/2)的元素。
 **/
public class BoyerMooreb {

    public static void main(String[] args) {
        int[] arr = {3,3,3,3,3,3,3,1,1,1,2,2};
        System.out.println(boyerMooreb(arr));
    }

    public static int boyerMooreb(int[] arr) {
        int result = 0;
        int count = 0;

        for (int i : arr) {
            if (count == 0) {
                result = i;
            }
            if (i == result) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }

}
