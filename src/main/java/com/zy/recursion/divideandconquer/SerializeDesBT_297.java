package com.zy.recursion.divideandconquer;

import org.junit.Test;

import java.util.*;

/**
 * @author:
 * @Date: 2020-02-23 16:30
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class SerializeDesBT_297 {

    private static String NULL = "null";

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String str = serialize(root);

        deserialize(str);
    }


    /**
     * Encodes a tree to a single string.
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        serializeRecursion(root, buffer);
        return buffer.toString();
    }

    private void serializeRecursion(TreeNode root, StringBuffer buffer) {
        if (root == null) {
            buffer.append(NULL + ",");
            return;
        }
        buffer.append(root.val + ",");
        serializeRecursion(root.left, buffer);
        serializeRecursion(root.right, buffer);
    }


    /**
     * Decodes your encoded data to tree.
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        Deque<String> data_list = new ArrayDeque<String>(Arrays.asList(data_array));

        return deserializeRecursion(data_list);
    }

    private TreeNode deserializeRecursion(Deque<String> data_list) {
        if (NULL.equals(data_list.getFirst())) {
            data_list.pollFirst();
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data_list.pollFirst()));
        root.left = deserializeRecursion(data_list);
        root.right = deserializeRecursion(data_list);

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
