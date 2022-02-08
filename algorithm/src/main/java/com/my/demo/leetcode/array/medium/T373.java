package com.my.demo.leetcode.array.medium;

import java.util.*;

/**
 * @author ffdeng2
 */
public class T373 {

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.stream().reduce(Integer::sum).orElse(0) - o2.stream().reduce(Integer::sum).orElse(0));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j : nums2) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(j);
                queue.add(list);
            }
        }
        while (k > 0 && !queue.isEmpty()) {
            result.add(queue.poll());
            k--;
        }
        return result;
    }

    public static List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        // 优先级队列，保存 [index1, index2]
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));

        // 把 nums1 的所有索引入队，nums2 的索引初始时都是 0
        // 优化：最多入队 k 个就可以了，因为提示中 k 的范围较小，这样可以提高效率
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            heap.offer(new int[] {i, 0});
        }

        List<List<Integer>> ans = new ArrayList<>();

        // 最多弹出 k 次
        while (k-- > 0 && !heap.isEmpty()) {
            int[] pos = heap.poll();

            ans.add(Arrays.asList(nums1[pos[0]], nums2[pos[1]]));

            // 将 index2 加 1 之后继续入队
            if (++pos[1] < nums2.length) {
                heap.offer(pos);
            }
        }

        return ans;
    }
}
