package com.leetcode.distributeCoins;

/**
 * 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，
 * 并且总共有 N 枚硬币。
 *
 * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。
 * (移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
 *
 * 返回使每个结点上只有一枚硬币所需的移动次数。
 *

 */

public class DistributeCoins {

    public int ans = 0;
    public int solution(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node){
        // if(node == null){
        //     return 0;
        // }
        // int oneVal = node.val-1;
        // int leftVal = dfs(node.left);
        // int rightVal = dfs(node.right);
        // int temp = Math.abs(leftVal) + Math.abs(rightVal);
        // ans = ans + temp;
        // return leftVal+rightVal+oneVal;
        /**
         * 思路2
         *
         */
        if(node == null){
            return 0;
        }
        int leftVal = dfs(node.left);
        int rightVal = dfs(node.right);
        node.val =node.val+ leftVal + rightVal;

        ans = ans+ Math.abs(leftVal) + Math.abs(rightVal);
        return node.val-1;

    }

    public static void main(String[] args) {

    }
}
