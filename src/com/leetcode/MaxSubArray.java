package com.leetcode;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] ints = new int[len];
        ints[0] = nums[0];
        int max = ints[0];
        for (int i=1;i<len;i++){
            if (ints[i-1]<0){
                ints[i] = nums[i];
            }else{
                ints[i] = ints[i-1]+nums[i];
            }
            max = Math.max(max,ints[i]);
        }
        return max;
    }

    public static void main(String[] args) {

        MaxSubArray maxSubArray = new MaxSubArray();
        int i = maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
}
