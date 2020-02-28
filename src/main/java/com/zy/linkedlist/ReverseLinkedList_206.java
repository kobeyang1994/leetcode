package com.zy.linkedlist;

/**
 * @author:
 * @Date: 2020-02-22 08:19
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class ReverseLinkedList_206 {
    /**
     * 不要造成指针丢失 结束条件也要判断好
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

}
