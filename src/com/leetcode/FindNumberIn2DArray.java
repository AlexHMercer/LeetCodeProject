package com.leetcode;


/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右非递减的顺序排序，
 * 每一列都按照从上到下非递减的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 */
public class FindNumberIn2DArray {

    //二分查找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;//行数
        if (row == 0){
            return false;
        }
        int col = matrix[0].length;//列数

        for (int i=0;i<row;i++){
            int start = 0;int end = col-1;
            while(start<=end){
                if (matrix[i][(start+end)/2]==target){
                    return true;
                }else if (matrix[i][(start+end)/2]>target){
                    end = ((start+end)/2)-1;
                }else{
                    start =1+((start+end)/2);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindNumberIn2DArray findNumberIn2DArray = new FindNumberIn2DArray();
        int[][] test = {{1,4,7,11,15},{2, 5, 8, 12, 19},{3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        boolean res = findNumberIn2DArray.findNumberIn2DArray(test,5);
        System.out.println(res);
    }
}
