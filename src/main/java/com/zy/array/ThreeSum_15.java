package com.zy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三
//元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例：
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针
/**
 * @author:
 * @Date: 2020-02-21 10:11
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class ThreeSum_15 {

    /**
     * a +b + c = 0
     * a + b = -c;
     * 时间复杂度 O(N)
     * 可以将排序的数组 用三个指针进行 计算
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        //使用三指针需要先排序
        Arrays.sort(nums);
        for(int i = 0 ;i < nums.length-1 ; i++) {
            if( i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+ 1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if(sum > 0){
                    while (left <right && nums[right] == nums[--right]);
                }else if(sum < 0){
                    while (left <right && nums[left] == nums[++left]);
                }else {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left <right && nums[right] == nums[--right]);
                    while (left <right && nums[left] == nums[++left]);
                }

            }
        }

        return  result;
    }
}