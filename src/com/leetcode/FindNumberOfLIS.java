package com.leetcode;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 *
 * 注意 这个数列必须是 严格 递增的。
 */
public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int ans = 0;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    if (dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    }else if (dp[j]+1 == dp[i]){
                        count[i] = count[i]+count[j];
                    }
                }
            }
            if (dp[i]>maxLen){
                maxLen = dp[i];
                ans = count[i];
            }else if (dp[i] == maxLen){
                ans = ans + count[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindNumberOfLIS findNumberOfLIS = new FindNumberOfLIS();
        int numberOfLIS = findNumberOfLIS.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
        System.out.println(numberOfLIS);
    }

}
