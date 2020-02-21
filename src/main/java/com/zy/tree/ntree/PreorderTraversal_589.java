package com.zy.tree.ntree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * n叉树 先序遍历 递归和迭代的
 * @author:
 * @Date: 2020-02-20 16:03
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class PreorderTraversal_589 {


    LinkedList<Integer> result = new LinkedList<>();

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> preordeRecursion(Node root) {
        if(root == null) {
            return result;
        }
        result.add(root.val);
        List<Node> childrenList =  root.children;
        if(childrenList != null) {
            childrenList.forEach(children ->{
                preorder(children);
            });
        }
        return result;
    }

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if(root == null) {
            return result;
        }

        Stack<Node> childStack = new Stack<>();

        childStack.push(root);

        while (!childStack.isEmpty()) {
            Node current = childStack.pop();
            result.add(current.val);
            List<Node> childrenList = current.children;
            if(childrenList != null) {
                for(int i = childrenList.size() -1 ;i >= 0 ; i--){
                    childStack.push(childrenList.get(i));
                }
            }

        }

        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
