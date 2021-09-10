package com.my.demo.leetcode.array.medium;

/**
 * @author ffdeng2
 */
public class T1894 {

    public static void main(String[] args) {
        int[] chalk = {3,4,1,2};
        int k = 25;
        System.out.println(chalkReplacer(chalk, k));
        System.out.println(chalkReplacer2(chalk, k));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        while (true) {
            for (int i = 0; i < chalk.length; i++) {
                if (chalk[i] <= k) {
                    k -= chalk[i];
                } else {
                    return i;
                }
            }
        }
    }

    public static int chalkReplacer2(int[] chalk, int k) {
        long sum = 0;
        for (int i : chalk) {
            sum += i;
        }

        int result = (int) (k % sum);
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > result) {
                return i;
            }
            result -= chalk[i];
        }
        return -1;
    }

}
