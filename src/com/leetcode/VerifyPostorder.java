package com.leetcode;

import java.util.LinkedList;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 二叉搜索树的左节点小于根节点，右节点大于根节点
 * 分析：
 *      因为给的是二叉搜索树的后续遍历序列，所以如果将这个序列倒过来看，就是镜像的先序遍历序列，（根->右->左）
 *      所以对倒序的后续遍历序列而言，从右向左，从根节点开始，先遍历右子树，
 *      直到所有的右子树遍历完成，再往前就是某个左节点的值
 *      而左节点的值一定是已经遍历过的右子树节点的左节点，
 *      这个时候将已经遍历过的右子树节点中 大于 当前指向节点的节点 出栈，并将其值赋值给max，
 *      max就代表当前指向的左节点的父节点的值，也代表剩余的后序遍历序列中不可能有比max还大的值，
 *      故只要在循环过程中出现了大于max的值，则说明所给的序列不是二叉搜索树的后序遍历序列
 *
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        // postorder是后序序列，所以最后的值一定是根节点，并且从后向前必然有若干个值是递增的，即右子树的值
        // 所以可以将单调栈引入，当某个索引指向的值小于栈顶的值时，就说明右子树的值已经搜索完了，那就向前推导，找左子树
        LinkedList<Integer> linkedList = new LinkedList<>();
        int max = Integer.MAX_VALUE;
        for (int i = postorder.length-1; i >= 0; i--) {
            if (postorder[i]>max){
                return false;
            }
            while (!linkedList.isEmpty() && postorder[i] < linkedList.peek()){
                max = linkedList.pop();
            }
            linkedList.push(postorder[i]);
        }
        return true;
    }
}
