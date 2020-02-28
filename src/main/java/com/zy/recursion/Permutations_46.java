package com.zy.recursion;

import org.junit.Test;

import java.util.*;

/**
 * @author:
 * @Date: 2020-02-24 09:21
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class Permutations_46 {

    /**
     * test case
     */
    @Test
    public void test() {
        System.out.println(permuteUnique(new int[]{1, 1, 3}));
    }


    private List<List<Integer>> result = new ArrayList<>();

    private int[] nums;


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        boolean[] flag = new boolean[nums.length];

        dfsLi(new ArrayList<>(), flag);
        return result;
    }

    private void dfsLi(ArrayList<Integer> data, boolean[] flag) {
        if (data.size() == nums.length) {
            result.add(new ArrayList<>(data));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(flag[i]){
                continue;
            }

            if(i > 0 && nums[i] == nums[i-1]&&flag[i-1]==false){
                continue;
            }

            flag[i] = true;
            data.add(nums[i]);
            dfsLi(data,flag);
            data.remove(data.size() -1);
            flag[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        boolean[] flag = new boolean[nums.length];
        dfs(flag, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(boolean[] flag, ArrayList<Integer> data, int length) {
        if (nums.length == length) {
            result.add(new ArrayList<>(data));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                continue;
            }
            data.add(nums[i]);
            flag[i] = true;
            dfs(flag, data, length + 1);
            data.remove(data.size() - 1);
            flag[i] = false;
        }
    }

    /**
     * 组合问题
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {

        LinkedList<Integer> numList = new LinkedList<>();
        for (int num : nums) {
            numList.add(num);
        }
        helper(numList, new ArrayList<>());
        return result;
    }

    private void helper(LinkedList<Integer> numList, ArrayList<Integer> data) {
        if (numList.isEmpty()) {
            result.add(data);
            return;
        }
        for (int i = 0; i < numList.size(); i++) {
            ArrayList<Integer> newData = (ArrayList<Integer>) data.clone();
            LinkedList<Integer> newNumList = (LinkedList<Integer>) numList.clone();
            //在这里进行剪枝
            newData.add(newNumList.remove(i));
            helper(newNumList, newData);
        }
    }

    Map<String, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> permuteUnique1(int[] nums) {
        LinkedList<Integer> numList = new LinkedList<>();
        for (int num : nums) {
            numList.add(num);
        }
        helperUnique(numList, new ArrayList<>(), new StringBuffer());
        return new ArrayList<>(map.values());
    }

    private void helperUnique(LinkedList<Integer> numList, ArrayList<Integer> data, StringBuffer stringBuffer) {
        if (numList.isEmpty()) {
            if (!map.containsKey(stringBuffer.toString())) {
                map.put(stringBuffer.toString(), data);
            }
            return;
        }

        for (int i = 0; i < numList.size(); i++) {
            ArrayList<Integer> newData = (ArrayList<Integer>) data.clone();
            LinkedList<Integer> newNumList = (LinkedList<Integer>) numList.clone();
            Integer in = newNumList.remove(i);
            newData.add(in);
            StringBuffer sb = new StringBuffer(stringBuffer.toString());
            sb.append(in);
            helperUnique(newNumList, newData, sb);
        }
    }


}

