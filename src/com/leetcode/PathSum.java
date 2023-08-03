package com.leetcode;

import com.leetcode.easy.issymmetricandprinttree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 分析：
 *      深度优先搜索，找所有符合条件的路径，每次遍历都是对一个节点的判断，
 *      在一次遍历完成后要记得把当期那节点从list中删去
 *      在找到一个路径，放到结果中时，要注意不能直接add
 *      由于临时list是函数的参数，所以函数结束时这个参数将被释放，其指向的内容也会变成空值
 *      应该新建一个对象进行存储，即
 *      this.ans.add(list); -> this.ans.add(new ArrayList<>(list));
 */
public class PathSum {
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.ans = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        dfs(root,0,target,tempList);
        return this.ans;
    }
    private void dfs(TreeNode node, int sum,int target, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (sum + node.val == target && node.left == null && node.right == null){
            this.ans.add(new ArrayList<>(list));
        }else{
            dfs(node.left, sum + node.val, target, list);
            dfs(node.right, sum + node.val, target, list);
        }
        // 当前节点结束后，把当前节点弹出
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        PathSum pathSum = new PathSum();
        List<List<Integer>> lists = pathSum.pathSum(treeNode, 3);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println("");
        }
    }
}
