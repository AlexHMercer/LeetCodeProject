package com.leetcode.easy;

import com.leetcode.issubstructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * 分析：
 *      二叉搜索树的中序遍历序列为递增序列
 */
public class KthLargest {
    List<Integer> list;
    public int kthLargest(TreeNode root, int k) {
        list = new ArrayList<>();
        minSquence(root);
            return list.get(list.size() - k);
    }

    private void minSquence(TreeNode root) {
        if (root!= null){
            minSquence(root.left);
            this.list.add(root.val);
            minSquence(root.right);
        }
    }
}
