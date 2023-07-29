package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 分析：
 *      这题的重点是dp[i]含义的确定，若是把dp[i]定义为0-i中最长递增子序列的长度，那么dp[i+1]无法根据dp[i]求得。
 *      所以应该把dp[i]定义为以nums[i]结尾的最长递增子序列的长度，这样就固定了每个子序列的最后一位
 *
 *      因此在确定dp[i]的时候，由于子序列比一定连续，nums[i]可能与前面的任何一个子序列构成递增序列，
 *      就要对前面的0~i-1个子序列进行遍历，如果nums[i]> nums[k]，k属于0~i-1，则dp[k]可以与nums[i]构成一个递增子序列
 *      这时dp[i]的值就是dp[k]+1。
 *      但是又要求最长，一个遍历中dp[i]可能会改变多次，所以取值时要dp[i] = Math.max(dp[i],dp[j]+1);
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        int maxIndex = 0;
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if(max<dp[i]){
                max = dp[i];
                maxIndex = i;
            }
//            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
        // 输出最长递增子序列,从maxIndex回溯
        int[] ans = new int[max];
        int ansIndex = 0;
        for (int i = maxIndex; i >=0 ; i--) {
            if (dp[i] == max){
                ans[ansIndex] = nums[i];
                max--;
                ansIndex++;
            }
        }
        for (int an : ans) {
            System.out.print(an+" ");
        }

        return max;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int i = lengthOfLIS.lengthOfLIS(new int[]{0,1,0,3,2,3});
        //System.out.println(i);
    }
}
