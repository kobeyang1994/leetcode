package com.zy.recursion.divideandconquer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:
 * @Date: 2020-02-24 12:11
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class LeetCode_105 {


    private int[] preorder;
    private int[] inorder;

    private int pre_index;

    private Map<Integer ,Integer> index_map = new HashMap<>(16);
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int index = 0;
        for(int i : inorder){
            index_map.put(i,index++);
        }
        return helper(0,inorder.length);
    }

    private TreeNode helper(int in_left,int in_right) {
        //terminator
        if(in_left == in_right){
            return null;
        }

        //process

        int pre_value = preorder[pre_index];
        //current parent node
        TreeNode node = new TreeNode(pre_value);

        Integer in_index = index_map.get(pre_value);

        pre_index++;

        node.left = helper(in_left ,in_index);

        node.right = helper(in_index + 1 ,in_right);

        return node;

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
