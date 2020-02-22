package com.zy.array;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表

import java.util.HashMap;
import java.util.Map;

/**
 * @author:
 * @Date: 2020-02-21 10:49
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> cache = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(!cache.containsKey(diff)){
                cache.put(nums[i],i);
            }else {
                return new int[]{cache.get(diff),i};
            }
        }
        return null;
    }
}

