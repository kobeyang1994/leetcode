package com.zy.tree.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//给定一个二叉树，返回它的中序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表

/**
 * @author: zy
 * @Date: 2020-02-20 10:00
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class InorderTraversal_94 {


    private List<Integer> result = new LinkedList<>();

    /**
     * firest solution  recursion
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        if (root == null) {
            return result;
        }
        inorderTraversalRecursion(root.left);
        result.add(root.val);
        inorderTraversalRecursion(root.right);
        return result;
    }

    public List<Integer> inorderTraversalLoop(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
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
