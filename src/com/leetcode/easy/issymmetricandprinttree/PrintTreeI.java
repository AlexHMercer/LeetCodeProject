package com.leetcode.easy.issymmetricandprinttree;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintTreeI {
    public int[] printTree(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        treeNodes.add(root);
        while(!treeNodes.isEmpty()){
            TreeNode tempNode = treeNodes.pop();
            if (tempNode.left != null){
                treeNodes.add(tempNode.left);
            }
            if (tempNode.right != null){
                treeNodes.add(tempNode.right);
            }
            integers.add(tempNode.val);
        }
        return integers.stream().mapToInt(Integer::intValue).toArray();
    }
}
