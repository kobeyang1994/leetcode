package com.zy.recursion;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author:
 * @Date: 2020-02-23 08:35
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class ValidateBSTree_98 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        isValidBST(root);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        isValidBST(root);
        System.out.println(true && true);
        System.out.println(true && false);

    }


    public boolean isValidBSTLoop(TreeNode root) {
        TreeNode current = root;
        double inorder = -Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null && !stack.isEmpty()) {
            while (current != null) {
                stack.add(current.left);
                current = current.left;
            }
            current = stack.pop();
            if(current.val <= inorder) {
                return false;
            }
            inorder = current.val;

            stack.push(current.right);
        }
        return true;
    }


    public boolean isValidBST(TreeNode root) {

        return helper(root, null, null);

    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }

        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(root.left, lower, val)) {
            return false;
        }
        if (!(helper(root.right, val, upper))) {
            return false;
        }
        return true;
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
