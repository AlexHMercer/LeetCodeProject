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
 * 快慢指针法：
 *      快慢指针fast，slow均从头指针出发，slow一次走一步，fast一次走两步，若没有环，fast会返回null，若有环则一定相遇
 *      当有环的时候：相遇肯定在环内，并且在slow进入环一圈之内相遇，
 *      假设环外元素a个，环开始到相遇元素b个，环剩余元素c个
 *      则直到第一次相遇slow走过的路程=a+b
 *      fast走过的路程=a+n(b+c)+b;n(b+c)表示在环内绕了多少圈
 *      又由于快慢指针走过的路径长度存在2倍关系，所以2(a+b) = a+n(b+c)+b;化简后得a = n(b+c)-b = (n-1)(b+c)+c;
 *      这代表，从相遇节点和头结点各自定义一个指针，每次两个指针后移一位，当这两个指针相遇时，指向的就是环的起始节点
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
