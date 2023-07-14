package com.leetcode.distributeCoins;



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
