package com.leetcode.easy.hascycle;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 注：
 * 本题还可以使用快慢指针方法优化空间复杂度，需要了解一下龟兔赛跑算法
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while(head != null){
            if (listNodes.contains(head)){
                return true;
            }else{
                listNodes.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        HasCycle hasCycle = new HasCycle();
    }
}
