package com.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 * 题目要求使用两个栈实现队列的功能，则两个栈一个负责保存输入数据一个负责弹出输出数据。
 * 当要求出队时，必须从弹出数据的那个栈弹出栈顶数据，当输出栈为空时，
 */
public class CQueue {

    // l1作为入栈队列，l2作为出栈队列
    public LinkedList<Integer> l1;
    public LinkedList<Integer> l2;
    public CQueue() {
        this.l1 = new LinkedList<>();
        this.l2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        this.l1.push(value);
    }

    public int deleteHead() {
        // 弹出节点的时候，首先检查l2是否为空，若不为空则从l2里面弹出节点，
        // 若为空则先把l1里的左右节点压入l2，再从l2中弹出

        if (this.l1.isEmpty()&&this.l2.isEmpty()){
            return -1;
        }
        while(this.l2.isEmpty()){
            while(!this.l1.isEmpty()){
                this.l2.push(this.l1.pop());
            }
        }
        return this.l2.pop();
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
