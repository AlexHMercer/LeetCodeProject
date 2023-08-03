package com.leetcode.easy.issymmetricandprinttree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PrintTreeII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int i = 1;
        nodes.add(root);
        while (!nodes.isEmpty()){
            // 先把nodes的左右分支全部放到tempNodes里，然后把nodes里的值放到list中
            LinkedList<TreeNode> tempNodes = new LinkedList<>();
            ArrayList<Integer> tempList = new ArrayList<>();
            for (TreeNode node : nodes) {
                tempList.add(node.val);
                if (node.left != null){
                    tempNodes.add(node.left);
                }
                if (node.right != null){
                    tempNodes.add(node.right);
                }
            }
            if (i%2 == 0){
                Collections.reverse(tempList);
            }
            lists.add(tempList);
            nodes = tempNodes;
            i++;
        }
        return lists;
    }
}
