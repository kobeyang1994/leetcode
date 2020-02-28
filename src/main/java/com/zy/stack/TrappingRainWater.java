package com.zy.stack;

import java.util.Stack;

/**
 * @author:
 * @Date: 2020-02-27 16:49
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int count = 0;
        while (count < height.length) {
            while (!stack.isEmpty() && height[stack.peek()] < height[count]) {
                int min = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int minHeight = Math.min(height[count], height[stack.peek()]);
                maxArea += (minHeight - min) * (count - stack.peek() - 1);
            }
            stack.push(count);
            count++;
        }
        return maxArea;
    }
}
