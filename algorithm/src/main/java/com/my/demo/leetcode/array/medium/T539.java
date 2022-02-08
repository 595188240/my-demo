package com.my.demo.leetcode.array.medium;

import java.util.Collections;
import java.util.List;

/**
 * @author ffdeng2
 */
public class T539 {

    public static void main(String[] args) {
        //List<String> timePoints = new ArrayList<>();
        //timePoints.add("23:59");
        //timePoints.add("00:00");
        //timePoints.add("00:00");
        //System.out.println(findMinDifference(timePoints));
    }

    public static int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < timePoints.size(); ++i) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes);
            preMinutes = minutes;
        }
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes);
        return ans;
    }

    public static int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }
}
