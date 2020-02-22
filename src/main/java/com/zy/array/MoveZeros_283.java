package com.zy.array;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针

/**
 * @author:
 * @Date: 2020-02-21 08:53
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class MoveZeros_283 {

    /**
     * 遍历满足条件站位
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        for (int i = count; i < nums.length; count++) {
            nums[i] = 0;
        }
    }

    /**
     * 双指针
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0 ;j< nums.length;j++) {
            if(nums[j] != 0 ){
                if(i != j) {
                    //因为是0可以直接给j
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
        }
    }

    /**
     * @param nums
     * @param i
     * @param j
     */
    private void exchange(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }


}
