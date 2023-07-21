package com.leetcode;

/**
 * 给定一个长度为 n 的环形整数数组nums，返回nums的非空 子数组 的最大可能和。
 *
 * 环形数组意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ，
 * nums[i]的前一个元素是 nums[(i - 1 + n) % n] 。
 *
 * 子数组 最多只能包含固定缓冲区nums中的每个元素一次。形式上，对于子数组nums[i], nums[i + 1], ..., nums[j]，
 * 不存在i <= k1, k2 <= j其中k1 % n == k2 % n。
 *
 */
public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int maxSubSum = nums[0];
        int minSubSum = nums[0];
        int[] max = new int[len];
        max[0]=nums[0];
        int[] min = new int[len];
        min[0] = nums[0];
        int sum = nums[0];
        for (int i = 1; i < len; i++) {
            // 找和最大的子数组
            if (max[i-1]>0){
                max[i] = nums[i] + max[i-1];
            }else{
                max[i] = nums[i];
            }
            maxSubSum = Math.max(maxSubSum,max[i]);
            // 找和最小的子数组
            if (min[i-1]<0){
                min[i] = min[i-1] + nums[i];
            }else{
                min[i] = nums[i];
            }
            minSubSum = Math.min(minSubSum,min[i]);
            sum = sum+nums[i];
        }

        // 最后，如果maxSubSum<0，就说明数组中所有的数字都小于等于0，这时最小的子数组就是数组本身，
        // 也就是说，这时候的最大子数组就是数组中最大的那个值，如果maxSubSum>=0，说明数组有非负值，
        // 这个时候，就用maxSubSum与sum-minSubSum比较，取最大的那个。
        if (maxSubSum<0){
            return maxSubSum;
        }else{
            return Math.max(maxSubSum,sum-minSubSum);
        }
    }

    public static void main(String[] args) {
        MaxSubarraySumCircular maxSubarraySumCircular = new MaxSubarraySumCircular();
        int i = maxSubarraySumCircular.maxSubarraySumCircular(new int[]{1, -2, 3, -2});
        System.out.println(i);
    }
}
