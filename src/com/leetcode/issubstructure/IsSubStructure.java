package com.leetcode.issubstructure;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class IsSubStructure {
    /**
     * 注意先序遍历结果对一棵树是唯一的，但是对B树而言，可能其只是A树中的一个部分，虽结构相同，但先序不同
     * @param t
     * @param ans
     */
    public void preOrderTraverse(TreeNode t, ArrayList<Integer> ans){
        if (t == null){
            return;
        }
        ans.add(t.val);
        preOrderTraverse(t.left,ans);
        preOrderTraverse(t.right,ans);
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        int rootB = B.val;
        ArrayList<Integer> preOrderB = new ArrayList<>();
        preOrderTraverse(B,preOrderB);
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(A);
        while(!treeNodes.isEmpty()){
            TreeNode tempNode = treeNodes.poll();
            if (tempNode.left != null) treeNodes.offer(tempNode.left);
            if (tempNode.right != null) treeNodes.offer(tempNode.right);
            if (tempNode.val == rootB){
                // 不使用先序遍历，使用递归遍历
//                ArrayList<Integer> preOrderA = new ArrayList<>();
//                preOrderTraverse(tempNode,preOrderA);
//                if (compare(preOrderA,preOrderB)){
//                    return true;
//                }
                if (treeCompare(tempNode,B)){
                    return true;
                }

            }
        }
        return false;
    }

    private boolean treeCompare(TreeNode tempNode, TreeNode b) {
        // 这里要注意的是，必须先判断b树是否为空，因为如果a，b树同时为空的话，应该返回true，
        if (b == null) return true;
        if (tempNode == null) return false;
        if (tempNode.val == b.val){
            if (treeCompare(tempNode.left,b.left) && treeCompare(tempNode.right,b.right)){
                return true;
            }
        }
        return false;
    }

    private boolean compare(ArrayList<Integer> preOrderA, ArrayList<Integer> preOrderB) {
        if (preOrderA.size() < preOrderB.size()){
            return false;
        }
        for (int i = 0; i < preOrderB.size(); i++) {
            if (!preOrderA.get(i).equals(preOrderB.get(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNodeA = new TreeNode(4);
        treeNodeA.left = new TreeNode(2);
        treeNodeA.right = new TreeNode(3);
        treeNodeA.left.left = new TreeNode(4);
        treeNodeA.left.right = new TreeNode(5);
        treeNodeA.right.left = new TreeNode(6);
        treeNodeA.right.right = new TreeNode(7);
        treeNodeA.left.left.left = new TreeNode(8);
        treeNodeA.left.left.right = new TreeNode(9);

        TreeNode treeNodeB = new TreeNode(4);
        treeNodeB.left = new TreeNode(8);
        treeNodeB.right = new TreeNode(9);
        IsSubStructure isSubStructure = new IsSubStructure();
        boolean subStructure = isSubStructure.isSubStructure(treeNodeA, treeNodeB);
        System.out.println(subStructure);

    }
}
