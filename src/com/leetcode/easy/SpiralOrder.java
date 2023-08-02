package com.leetcode.easy;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0){
            return new int[]{};
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int left = 0;
        int right = colLen - 1;
        int upper = 0;
        int lower = rowLen - 1;
        int k = 0;
        int[] ans = new int[rowLen*colLen];
        while(true){
            // 右移判断
            for (int i = left; i <= right ; i++) {
                ans[k++] = matrix[upper][i];
            }
            upper++;
            if (upper>lower){
                return ans;
            }
            // 下移判断
            for (int i = upper; i <= lower; i++) {
                ans[k++] = matrix[i][right];
            }
            right--;
            if (right<left){
                return ans;
            }
            // 左移判断
            for (int i = right; i >= left; i--) {
                ans[k++] = matrix[lower][i];
            }
            lower--;
            if (lower<upper){
                return ans;
            }
            // 上移判断
            for (int i = lower; i >= upper; i--) {
                ans[k++] = matrix[i][left];
            }
            left++;
            if (left>right){
                return ans;
            }
        }
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[] ints = spiralOrder.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        for (int i : ints) {
            System.out.print(i+" ");

        }
    }
}
