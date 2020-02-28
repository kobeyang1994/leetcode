package com.zy.stack;

import java.util.Stack;

/**
 * @author:
 * @Date: 2020-02-27 09:57
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class LargestRectangle {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> leftBorder = new Stack<>();
        leftBorder.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (leftBorder.peek() != -1 && heights[leftBorder.peek()] > heights[i]) {
                maxArea = Math.max(maxArea, heights[leftBorder.pop()] * (i - 1 - leftBorder.peek()));
            }
            leftBorder.push(i);
        }
        while (leftBorder.peek() != -1) {
            maxArea = Math.max(maxArea, heights[leftBorder.pop()] * (heights.length - 1 - leftBorder.peek()));
        }
        return maxArea;
    }

}
