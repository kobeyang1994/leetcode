package com.zy.recursion.divideandconquer;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:
 * @Date: 2020-02-23 11:49
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class MaxDepBT_104 {


    @Test
    public void test(){
        List<Integer> result = new LinkedList<>();


        System.out.println(result.isEmpty());

        result.addAll(null);
        System.out.println(result.isEmpty());
        result.add(null);
        System.out.println(result.size());
        System.out.println(result.isEmpty());

    }

    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if(root == null) {
            return maxDepth;
        }
        List<TreeNode> preNodeLevel = Arrays.asList(root);
        while (!preNodeLevel.isEmpty()) {
            List<TreeNode> currentNodeLevel = new LinkedList<>();
            for(TreeNode parent : preNodeLevel) {
                if(parent.left != null) {
                    currentNodeLevel.add(parent.left);
                }
                if(parent.right != null) {
                    currentNodeLevel.add(parent.right);
                }
            }
            maxDepth++;
            preNodeLevel = currentNodeLevel;
        }
        return maxDepth;
    }

    /**
     * 当前节点的最大高度等于 左右子树最大高度+1
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
       if(root == null) {
           return 0;
       }
       int left = maxDepth2(root.left);
       int right = maxDepth2(root.right);

       return Math.max(left,right) + 1;
    }




    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
