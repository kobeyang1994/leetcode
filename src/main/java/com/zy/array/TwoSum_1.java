package com.zy.array;



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

