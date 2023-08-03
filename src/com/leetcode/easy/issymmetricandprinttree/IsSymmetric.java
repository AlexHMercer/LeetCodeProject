package com.leetcode.easy.issymmetricandprinttree;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 分析：
 *      判断二叉树镜像需要判断左右子树对称且对应的节点相等
 *      镜像需要判断左子树的左子树 == 右子树的右子树 && 左子树的右子树 == 右子树的左子树
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        boolean ans = check(root,root);
        return ans;
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
    }
}
