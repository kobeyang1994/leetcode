package com.zy.linkedlist;

/**
 * @author:
 * @Date: 2020-02-22 08:40
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class ReverseNodeKGroup_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        if(count == k) {
            if(current != null){
                current = reverseKGroup(current,k);
            }
            while (count-- > 0 ){
                ListNode next = head.next;

                head.next = current;

                current = head;
                head = next;
            }

            head = current;
        }
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
