package com.my.demo.leetcode.string;

/**
 * @author ffdeng2
 */
public class T551 {

    public static void main(String[] args) {
        String s = "PPALLL";
        System.out.println(checkRecord(s));
    }

    public static boolean checkRecord(String s) {
        // Absent，缺勤
        char a = 'A';
        // Late，迟到
        char l = 'L';
        // Present，到场
        char p = 'P';

        int aNum = 0;
        int lNum = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                aNum++;
                if (aNum == 2) {
                    return false;
                }
            }
            if (arr[i] == l) {
                    lNum++;
                if (lNum == 3) {
                    return false;
                }
            } else {
                lNum = 0;
            }
        }
        return true;
    }

}
