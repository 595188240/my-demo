package com.my.demo.leetcode.string;

/**
 * @author ffdeng2
 */
public class T165 {

    public static void main(String[] args) {
        String s1 = "7.5.2.4";
        String s2 = "7.5.3";
        System.out.println(compareVersion(s1, s2));
    }

    public static int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int index1 = 0;
        int index2 = 0;
        int temp1;
        int temp2;
        while (index1 < split1.length || index2 < split2.length) {
            if (index1 >= split1.length) {
                temp1 = 0;
            } else {
                temp1 = Integer.valueOf(split1[index1]);
            }
            index1++;
            if (index2 >= split2.length) {
                temp2 = 0;
            } else {
                temp2 = Integer.valueOf(split2[index2]);
            }
            index2++;
            if (temp1 > temp2) {
                return 1;
            }
            if (temp1 < temp2) {
                return -1;
            }
        }
        return 0;
    }

}
