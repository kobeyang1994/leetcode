package com.zy.array;

/**
 * @author:
 * @Date: 2020-02-21 11:12
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class RorateArray_189 {

    /**
     * 依次向后交换
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if(k == 0){
            return;
        }
        int len = nums.length;
        int count = 0;
        for (int start = 0; count < nums.length ; start++) {
            int currentIndex = start;
            int current = nums[start];
            do {
                int nextIndex = (start + k) % len;
                int next = nums[nextIndex];
                nums[next] = current;
                currentIndex = nextIndex;
                current = next;
                count++;
            }while (currentIndex == start);
        }
    }



    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        if(k == 0) {
            return;
        }
        k = k % len;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);

    }

    private void reverse(int[] nums, int start, int end) {

        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
