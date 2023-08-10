package com.leetcode.hard;

/**
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 *
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，
 * 相邻数字不在原数组的同一列。
 */
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int firstMinSum = 0;
        int secondMinSum = 0;
        int firstMinIndex = -1;

        for (int i = 0; i < n; i++) {
            int curFirstMinSum = Integer.MAX_VALUE;
            int curSecondMinSum = Integer.MAX_VALUE;
            int curFirstMinIndex = -1;

            for (int j = 0; j < n; j++) {
                int cur_sum = (j != firstMinIndex ? firstMinSum : secondMinSum) + grid[i][j];
                if (cur_sum < curFirstMinSum) {
                    curSecondMinSum = curFirstMinSum;
                    curFirstMinSum = cur_sum;
                    curFirstMinIndex = j;
                } else if (cur_sum < curSecondMinSum) {
                    curSecondMinSum = cur_sum;
                }
            }
            firstMinSum = curFirstMinSum;
            secondMinSum = curSecondMinSum;
            firstMinIndex = curFirstMinIndex;
        }
        return firstMinSum;
    }

    public static void main(String[] args) {
        MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
        int i = minFallingPathSum.minFallingPathSum(new int[][]{{-37,51,-36,34,-22},{82,4,30,14,38},{-68,-52,-92,65,-85},{-49,-3,-77,8,-19},{-60,-71,-21,-62,-73}});
        System.out.println(i);

    }
}
