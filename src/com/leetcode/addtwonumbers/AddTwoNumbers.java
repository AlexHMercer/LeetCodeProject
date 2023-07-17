package com.leetcode.addtwonumbers;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 */


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int temp = 0;
        ListNode ans = new ListNode();
        ListNode index = ans;
        while(l1 != null ||l2 !=null || carry != 0){
            if (l1!=null){
                carry = carry +l1.val;
            }
            if (l2!=null){
                carry = carry + l2.val;
            }
            ListNode node = new ListNode(carry%10);
            ans.next = node;
            ans = node;
            carry = carry/10;
            // 与数组不同，数组的索引可以直接++，在while中判断索引是否越界，
            // 链表在获取下一位时需要验证当前节点是否存在。
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        // 因为先建立了一个ans头结点，在while循环中每次的计算结果存放在一个新的节点中，
        // 因此头结点并未赋值，结果从头结点的下一个节点开始
        return index.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = new ListNode();
        System.out.println(listNode.val);
        //ListNode listNode = addTwoNumbers.addTwoNumbers();
//        while(listNode != null){
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
    }
}
