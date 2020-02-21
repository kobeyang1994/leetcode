package com.zy.tree.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author:
 * @Date: 2020-02-20 10:07
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class PeorderTraversal_144 {


    private List<Integer> result = new LinkedList<>();

    /**
     * recursion
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalRescu(TreeNode root) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        preorderTraversalRescu(root.left);
        preorderTraversalRescu(root.right);
        return result;
    }

    /**
     * loop
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalLoop(TreeNode root) {
        if (root == null) {
            return result;
        }
        Stack<TreeNode> childNode = new Stack<>();
        childNode.push(root);
        while (!childNode.isEmpty()) {
            TreeNode current = childNode.pop();
            result.add(current.val);
            if (current.right != null) {
                childNode.push(current.right);
            }

            if (current.left != null) {
                childNode.push(current.left);
            }
        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
