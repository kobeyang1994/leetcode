package com.zy.recursion;

import javafx.util.Pair;

/**
 * @author:
 * @Date: 2020-02-23 16:21
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class MinuDepBT_111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;

        if(root.left != null) {
             min_depth = Math.min(minDepth(root.left),min_depth);
        }
        if(root.right != null) {
            min_depth  = Math.min(minDepth(root.right),min_depth);
        }
        return min_depth;
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
