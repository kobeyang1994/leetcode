package com.zy.convert.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:
 * @Date: 2020-02-26 15:55
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class ArrayConvert {

    @Test
    public void test(){
        ArrayList<Integer> re = (ArrayList)arrayToList2(new Integer[]{1,2,3});
    }
    /**
     * 组合问题
     * @param nums
     * @return
     */
    public static List<Integer> arrayToList(int[] nums) {
       return   Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

    }

    private List<Integer> arrayToList2(Integer[] nums){
        return Arrays.asList(nums);
    }

}
