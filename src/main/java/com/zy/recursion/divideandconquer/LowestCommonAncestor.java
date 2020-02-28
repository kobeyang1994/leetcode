package com.zy.recursion.divideandconquer;


import java.util.*;

/**
 * @author:
 * @Date: 2020-02-25 08:24
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class LowestCommonAncestor {

    private TreeNode ans;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean flag = true;
        while (!stack.isEmpty() && flag) {
            TreeNode current = stack.peek();

            if(current.right != null){
                stack.push(current.right);
            }
            if(current.left != null){
                stack.push(current.left);
            }
        }

        return null;
    }

    public TreeNode lowestCommonAncestorParent(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>(16);
        parent.put(root, null);
        stack.add(root);
        while (!(parent.containsKey(p) && parent.containsKey(q))) {
            TreeNode current = stack.pop();

            if (current.left != null) {
                stack.push(current.left);
                parent.put(current.left, current);
            }
            if (current.right != null) {
                stack.push(current.right);
                parent.put(current.right, current);
            }
        }
        Set<TreeNode> ancestor = new TreeSet<>();
        while (p != null) {
            ancestor.add(p);
            p = parent.get(p);
        }

        while (!ancestor.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }

    public TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q) {
        recursionTree(root, q, p);
        return ans;
    }

    private boolean recursionTree(TreeNode root, TreeNode q, TreeNode p) {
        if (root == null) {
            return false;
        }

        int left = recursionTree(root.left, q, p) ? 1 : 0;

        int right = recursionTree(root.right, q, p) ? 1 : 0;

        int mid = (root == p || root == q) ? 1 : 0;

        if (mid + left + right >= 2) {
            this.ans = root;
        }
        return (mid + left + right > 0);
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
