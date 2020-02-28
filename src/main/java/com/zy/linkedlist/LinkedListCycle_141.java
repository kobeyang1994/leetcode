package com.zy.linkedlist;

/**
 * @author:
 * @Date: 2020-02-22 08:24
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class LinkedListCycle_141 {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
