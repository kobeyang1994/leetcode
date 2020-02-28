package com.zy.linkedlist;

/**
 * @author:
 * @Date: 2020-02-22 11:36
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class DeleteLastKNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int count = 0;
        while (current != null && count < n) {
            current = current.next;
            count++;
        }

        if (current == null) {
            if (count == n) {
                head = head.next;
            }
            return head;
        }

        ListNode preKNode = head;
        while (current != null) {
            preKNode = preKNode.next;
            current = current.next;
        }

        preKNode.next = preKNode.next.next;
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
