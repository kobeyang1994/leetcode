package com.zy.tree.ntree;

import java.util.*;

/**
 * n叉树的广度优先遍历
 * @author:
 * @Date: 2020-02-21 08:11
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class LevelOrderTraversal_429 {

    private List<List<Integer>> resultRecursion = new LinkedList<>();

    /**
     * 如果用递归进行遍历的话  得到的顺序就是从最后一层向上 的数据，所以需要把每一层的存储集合先初始化了
     * 就可以保证是从上向下存储了。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return resultRecursion;
        }
        levelOrderResursion(root, 0);
        return resultRecursion;
    }

    private void levelOrderResursion(Node root, int level) {
        if (resultRecursion.size() <= level) {
            resultRecursion.add(new LinkedList<>());
        }
        resultRecursion.get(level).add(root.val);
        if (root.children == null) {
            return;
        }
        for (Node children : root.children) {
            levelOrderResursion(children,level+1);
        }
    }

    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderDeque(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> nLevelNodeQu = new LinkedList<>();
        nLevelNodeQu.add(root);

        while (!nLevelNodeQu.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = nLevelNodeQu.size();
            for (int i = 0; i < size; i++) {
                Node current = nLevelNodeQu.pollFirst();
                level.add(current.val);
                if (current.children != null) {
                    nLevelNodeQu.addAll(current.children);
                }
            }
            result.add(level);
        }
        return result;
    }

    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderLoop(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<Node> preLevelNode = Arrays.asList(root);
        while (!preLevelNode.isEmpty()) {
            List<Node> currentLevelNode = new LinkedList<>();
            List<Integer> preLevelVal = new LinkedList<>();
            for (Node current : preLevelNode) {
                currentLevelNode.addAll(current.children);
                preLevelVal.add(current.val);
            }
            result.add(preLevelVal);
            preLevelNode = currentLevelNode;
        }
        return result;

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
