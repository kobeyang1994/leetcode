package com.zy.linkedlist;

/**
 * @author:
 * @Date: 2020-02-22 08:30
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }



    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
