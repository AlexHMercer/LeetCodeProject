package com.leetcode;
/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */

import com.leetcode.reorderlist.ListNode;
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode pre = new ListNode();
        left = head;
        right = head.next;
        ListNode ans = right;
        while(left != null && right != null){
            // 左右交换
            left.next = right.next;
            right.next = left;
            pre.next = right;
            pre = left;
            if (left.next == null || left.next.next == null) break;
            left = left.next;
            right = left.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode listNode1 = swapPairs.swapPairs(listNode);
        while (listNode1 != null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
