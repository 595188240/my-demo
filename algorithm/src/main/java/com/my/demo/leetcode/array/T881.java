package com.my.demo.leetcode.array;

import java.util.Arrays;

/**
 * @author ffdeng2
 */
public class T881 {

    public static void main(String[] args) {
        int[] people = {1,2,2,3};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int length = people.length;
        int begin = 0;
        int end = length - 1;
        int result = 0;
        while (begin <= end) {
            if (people[begin] + people[end] <= limit) {
                begin++;
            }
            end--;
            result++;
        }
        return result;
    }

}
