package com.leetcode.easy;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        int[][] ints = new int[grid.length][grid[0].length];
        ints[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            ints[0][i] = grid[0][i] + ints[0][i-1];
        }
        for (int i = 1; i < grid.length; i++) {
            ints[i][0] = grid[i][0] + ints[i-1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                ints[i][j] = Math.max(ints[i-1][j],ints[i][j-1])+grid[i][j];
            }
        }
        return ints[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        MaxValue maxValue = new MaxValue();
        int i = maxValue.maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(i);
    }
}
