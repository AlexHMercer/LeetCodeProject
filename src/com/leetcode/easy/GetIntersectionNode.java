package com.leetcode.easy;

import com.leetcode.easy.hascycle.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * 分析：
 *      本题给出的链表如有公共节点，则公共节点之后均为公共节点，即两个链表在某节点后合二为一
 *      要在时间复杂度O(N)条件下完成查找第一个公共节点，可以使用双指针法
 *      设两个链表的相同的长度为a（可为0），链表1除a之外的长度为b，链表2除a之外的长度为c，
 *      则b+a+c = c+a+b，即从链表1的头出发，走完链表1再到链表2再到第一个公共节点的距离，等于，
 *      从链表2的头出发，走完链表2再到链表1再到第一个公共节点的距离。两个指针走过两个相同距离后，均指向第一个公共节点
 *      如果两个链表没有公共节点，a=0，b+c = c+b，两个指针走过两个链表后均为null
 */
public class GetIntersectionNode {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while(node1 != node2){
            if (node1 == null){
                node1 = headB;
            }else{
                node1 = node1.next;
            }
            if (node2 == null){
                node2 = headA;
            }else{
                node2 = node2.next;
            }
        }
        return node1;
    }
}
