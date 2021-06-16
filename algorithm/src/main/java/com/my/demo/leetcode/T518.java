package com.my.demo.leetcode;

/**
 * @author ffdeng
 * @date 2021/6/10 17:14
 * 零钱兑换 dp
 */
public class T518 {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
       int[] result = new int[amount + 1];
       result[0] = 1;
        for (int coin : coins) {
            if (coin > amount) {
                break;
            }
            for (int i = coin; i <= amount; i++) {
                result[i] += result[i - coin];
            }
        }
        return result[amount];
    }

}
