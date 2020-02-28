package com.zy.loop.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:
 * @Date: 2020-02-26 11:07
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class Recursion {
    private int[] reworsds = new int[]{1, 2, 5, 10};


    @Test
    public void test(){
        List<List<Integer>> lists = get(10);
        System.out.println(lists.size());
    }

    public List<List<Integer>> get(int total) {
        List<List<Integer>> result = new ArrayList<>();
        helper(total, result, new ArrayList<>());
        return result;
    }

    private void helper(int total, List<List<Integer>> result, ArrayList<Integer> data) {
        //结束条件
        if (total == 0) {
            result.add(data);
            return;
        }

        if (total < 0) {
            return;
        }

        for (int i = 0; i < reworsds.length; i++) {
            ArrayList<Integer> newData = (ArrayList<Integer>) data.clone();
            newData.add(reworsds[i]);
            helper(total - reworsds[i], result, newData);
        }

    }
}
