package com.leetcode.reorderlist;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 注：本题我使用了双指针求解，O(n^2)，但是，可以先找到链表的后半段，然后反转后半段，再将其与前半段交替合并
 *
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode ans = head;
        // 首先找头尾指针
        ListNode left = head.next;
        while(head.next != null){
            head = head.next;
        }
        ListNode right = head;
        head = ans;
        while(left != right){
            ans.next = right;
            ans.next.next = left;
            if (left.next == right){
                ans = ans.next.next;
                ans.next = null;
                break;
            }
            left = left.next;
            ListNode tempRight = left.next;
            while(tempRight.next != right){
                tempRight = tempRight.next;
            }
            right = tempRight;
            if (left == right){
                ans = ans.next.next;
                ans.next = right;
                ans.next.next = null;
            }
            ans = ans.next.next;
            ans.next = null;
        }
    }
}
