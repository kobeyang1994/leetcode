package com.zy.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author:
 * @Date: 2020-02-27 16:34
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class SlidingWindowMax {

    private void refreshWindow(Deque<Integer> deque, int i, int k, int[] nums) {
        if (!deque.isEmpty() && deque.getFirst() == (i - k)) {
            deque.removeFirst();
        }
        while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
            deque.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len * k == 0) {
            return nums;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            refreshWindow(deque, i, k, nums);
            deque.addLast(i);
            if (nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int[] maxData = new int[len - k + 1];

        maxData[0] = nums[maxIndex];

        for (int i = k; i < len; i++) {
            refreshWindow(deque, i, k, nums);
            deque.addLast(i);
            maxData[i - k + 1] = nums[deque.getFirst()];
        }

        return maxData;
    }

}
