package com.leetcode;

/**
 * 给你一个 n x n 的 方形 整数数组matrix ，请你找出并返回通过 matrix 的下降路径的最小和 。
 *
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col)
 * 或者 (row + 1, col + 1) 。
 * 思路：
 * 部分贪心算法，路径的选取有局限性，即每次的路径选择只能在三个数字中选。
 * 因此对每个单元格而言，应该选取上一级路径中的最小和的路径，第一行没有前驱，则直接复制，
 * 从第二行开始，每个单元格的最小路径和就是当期那单元格的值加上一行对应单元格（最多三个）中的最小值
 * 注意：
 * 在查找上一行的最小值时，通过上一行同一列的值作为中继，分别与左右的值比较。
 * 这统一处理了，第一列和最后一列的仅有两个的情况。对中间的值，两次比较能够将最小值挑出来。
 */
public class MinFallingPathSum {

    public int solution(int[][] matrix){
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int i=0;i<n;i++){
            if (i==0){
                //第一行直接复制
                for (int k = 0;k<n;k++){
                    result[i][k] = matrix[i][k];
                }
                continue;
            }
            //从第二行开始，每个单元格与上层的对应最小值相加
            for (int j=0;j<n;j++){
                //找到正上方的值，方便对第一列和最后一列的值进行比对
                int temp = result[i-1][j];
                //先和右边的比较
                if (j<n-1){
                    temp = Math.min(temp,result[i-1][j+1]);
                }
                //再和左边比较
                if (j>0){
                    temp = Math.min(temp,result[i-1][j-1]);
                }
                //此时的temp就是对应三个数里面的最小值,temp再和当前单元格值相加
                result[i][j] = matrix[i][j]+temp;
            }
        }
        //再查找最后一行的最小值
        int min = result[n-1][0];
        for (int l = 1;l<n;l++){
            min = Math.min(min,result[n-1][l]);
        }
        return min;
    }

    public static void main(String[] args) {
        MinFallingPathSum slove = new MinFallingPathSum();
        int[][]  m = {{2,1,3},{6,5,4},{7,8,9}};
        int ans = slove.solution(m);
        System.out.println(ans);
    }
}
