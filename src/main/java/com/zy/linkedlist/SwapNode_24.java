package com.zy.linkedlist;

/**
 * @author:
 * @Date: 2020-02-22 08:35
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class SwapNode_24 {
    /**
     * 两两交换链表中的节点
     * Loop
     *
     * @param head
     * @return
     */
       public ListNode swapPairs(ListNode head) {
        ListNode solied = new ListNode(-1);
        ListNode pre = solied;
        solied.next = head;
        while (head != null && head.next != null) {
            ListNode next = head.next;

            head.next = next.next;
            next.next = head;
            pre.next = next;

            pre = head;
            head = head.next;
        }

        return solied.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
