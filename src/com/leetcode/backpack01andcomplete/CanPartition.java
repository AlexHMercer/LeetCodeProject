package com.leetcode.backpack01andcomplete;


/**
 * 给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            max = Math.max(max, nums[i]);
        }
        if (sum%2 != 0){
            return false;
        }
        sum = sum/2;
        if (max > sum) {
            return false;
        }
        /**
         * 注意这个部分的空间复杂度可以优化，由于每次更新只和上一行的状态有关，那么可以只用一行来代替矩阵
         *
         * 要注意的是，由于行后面的部分的数据要依赖于上一个状态的行的前半部分数据，所以内层循环应从后往前遍历
         * 同时为防止越界，j应该遍历到nums[i]停止
         */
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >=nums[i]; j--) {
                dp[j] = dp[j] ||dp[j-nums[i]];
            }
            if (dp[sum]){
                return true;
            }
        }
        return false;

        /**法一
        // dp[i][j]代表数组中前i个数中能否找到若干个数之和等于j
        boolean[][] dp = new boolean[nums.length][sum+1];
        // 当目标和为0是，任意的数都可以组成
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                // 当当前值nums[i]大于目标值j是，当前值不会被选择，所以当前单元格的值=dp[i-1][j]
                if (nums[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    // 当当前值nums[i]小于目标值j是，当前值选择或不选择都行，
                    // 所以当前单元格的值dp[i-1][j]和dp[i-1][j-nums[i]]中为true的那个
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
                if (dp[i][sum]){
                    return true;
                }
            }
        }
        return false;
         **/
    }

    public static void main(String[] args) {
        CanPartition canpartition = new CanPartition();
        boolean b = canpartition.canPartition(new int[]{1, 5, 11, 5});
        System.out.println(b);
    }
}
