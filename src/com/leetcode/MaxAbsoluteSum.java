package com.leetcode;

/**
 * 给你一个整数数组nums。一个子数组[numsl, numsl+1, ..., numsr-1, numsr]的和的绝对值为
 * abs(numsl + numsl+1 + ... + numsr-1 + numsr)。
 *
 * 请你找出 nums中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值。
 * 分析：
 *      和的绝对值的最大值有两种情况，一是最大值的绝对值，二是最小值的绝对值，
 *      这样问题就转化为了求子数组的最大最小值，典型的dp
 */
public class MaxAbsoluteSum {
    public int maxAbsoluteSum(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1][0]>=0){
                dp[i][0] = dp[i-1][0]+nums[i];
            }else{
                dp[i][0] = nums[i];
            }
            if (dp[i-1][1]<=0){
                dp[i][1] = dp[i-1][1]+nums[i];
            }else{
                dp[i][1] = nums[i];
            }
            int tempmax = Math.max(Math.abs(dp[i][0]),Math.abs(dp[i][1]));
            max = Math.max(tempmax,max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxAbsoluteSum maxAbsoluteSum = new MaxAbsoluteSum();
        int i = maxAbsoluteSum.maxAbsoluteSum(new int[]{1,-3,2,3,-4});
        System.out.println(i);
    }
}
