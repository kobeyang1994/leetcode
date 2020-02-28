package com.zy.recursion;

import org.junit.Test;

import java.util.Stack;

/**
 * @author:
 * @Date: 2020-02-23 08:15
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class InvertBinaryTree_226 {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        invertTree(treeNode);
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        Stack<TreeNode> levelNodes = new Stack<>();
        levelNodes.push(root);

        while (!levelNodes.isEmpty()) {
            TreeNode currentNode = levelNodes.pop();

            TreeNode left = currentNode.left;

            currentNode.left = currentNode.right;

            currentNode.right = left;

            if (currentNode.left != null) {
                levelNodes.add(currentNode.left);
            }
            if (currentNode.right != null) {
                levelNodes.add(currentNode.right);
            }
        }

        return root;
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
