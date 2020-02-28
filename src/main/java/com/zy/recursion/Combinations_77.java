package com.zy.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.LinkedList;

/**
 * @author:
 * @Date: 2020-02-24 08:44
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class Combinations_77 {
    @Test
    public void test() {
        int i = 0;
        System.out.println(i++ + 1);
        System.out.println(i);
        System.out.println(combine(4, 2));
    }


    private int n;
    private int k;

    private LinkedList<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
            this.n  = n;
            this.k = k;

        backRack(1,new LinkedList<>());
            return result;
    }

    /**
     * 回溯 判断条件不符合就结束
     * @param first
     * @param data
     */
    private void backRack(int first, LinkedList<Integer> data) {
        if(data.size() == this.k){
            result.add(new ArrayList<>(data));
            return;
        }

        for (int j = first; j <= n; j++) {
            data.add(j);
            backRack(j+1,data);
            data.removeLast();
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
       LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            nums.add(i);
        }
        //循环结束条件
        nums.add(n+1);
        int count = 0;
        List<List<Integer>> result = new ArrayList<>();
        while(count < k){
            result.add(new LinkedList<>(nums.subList(0,k)));

            count = 0;
            while(count < k && nums.get(count+1) == nums.get(count) + 1){
                nums.set(count ,count++ +1);
            }
            nums.set(count,nums.get(count)+1);
        }
        return result;
    }



    /**
     * C(n,k) = C(n-1,k-1) + C(n-1,k);
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine1(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }

        List<List<Integer>> result = combine1(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(combine1(n - 1, k));
        return result;
    }

}
