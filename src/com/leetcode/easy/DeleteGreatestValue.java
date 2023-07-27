package com.leetcode.easy;

import java.util.Arrays;

/**
 * 给你一个 m x n 大小的矩阵 grid ，由若干正整数组成。
 *
 * 执行下述操作，直到 grid 变为空矩阵：
 *
 * 从每一行删除值最大的元素。如果存在多个这样的值，删除其中任何一个。
 * 将删除元素中的最大值与答案相加。
 * 注意 每执行一次操作，矩阵中列的数据就会减 1 。
 *
 * 返回执行上述操作后的答案
 *
 */
public class DeleteGreatestValue {
    public int deleteGreatestValue(int[][] grid) {
        int sum = 0;
        for(int i = 0;i<grid.length;i++){
            Arrays.sort(grid[i]);
        }
        for (int i = 0; i < grid[0].length; i++) {
            int temp = 0;
            for (int j = 0; j < grid.length; j++) {
                temp = Math.max(temp,grid[j][i]);
            }
            sum = sum + temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        DeleteGreatestValue deleteGreatestValue = new DeleteGreatestValue();
        int i = deleteGreatestValue.deleteGreatestValue(new int[][]{{1, 2, 4}, {3, 3, 1}});
        System.out.println(i);
    }
}
