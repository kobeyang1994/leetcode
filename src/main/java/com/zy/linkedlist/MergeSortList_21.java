package com.zy.linkedlist;

/**
 * @author:
 * @Date: 2020-02-22 11:31
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class MergeSortList_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode solied = new ListNode(-1);
        ListNode next = solied;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                next.next = l1;
                l1 = l1.next;
            }else{
                next.next = l2;
                l2 = l2.next;
            }
            next = next.next;
        }
        if(l1 == null){
            next.next = l2;
        }
        if(l2 == null) {
            next.next = l1;
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
