package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 问题2：给出到达最后一个下标的最小次数
 * 法1：从后往前，O(n^2)
 * 法2：从前往后，O(n)
 *      从前往后就是：每一个位置都可以确定可到达的范围，在这个范围中又可以根据值确定最大的下一个可到达范围，
 *      这样就能通过一次遍历找到最小次数。先标记end和最大可到达范围，遍历中，最大可到达范围根据值的不同而不同，
 *      在遍历完end之前的值之后，将end调整为最大可到达范围，当end>=最右边的index时，最小次数就得到了。
 *
 * 分析：
 *      题目要求判断能否根据数组中的步数到达最后一个下标，而能否到达此下标与上一个所在的位置有关，
 *      因此可以从当前下标开始，逐个判断前面的位置能否直接到达当前下标。能直接到达就再往前迭代
 *      当位置为k时不能直接到达当前下标，就说明第一个能够到达当前下标位置为k+1，
 *      所以，把尾指针移动到下标1，并且继续往前遍历
 *      直到遍历指针指向了数组第一个下标，如果此时第一个下标可以直接到达当前的尾节点，那么就说明数组满足题意，return true
 *      如果遍历指针指向了数组第一个下标但第一个下标不能到达当前的尾节点，就说明数组不满足题意，return false
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int start = 0;
        int end = nums.length - 1;
        // 先从最后的索引开始，找到能一次跳转到最后一个索引的坐标位置存放到一个List里
        LinkedList<Integer> indexes = new LinkedList<>();
        int i = end - 1;
        while(i>=0){
            if (end - i <= nums[i]){
                if (i == 0){
                    return true;
                }
                end = i;
            }
            i--;
        }
        return false;
    }
    public int jump(int[] nums) {
        if (nums.length == 1){
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int minStep = dp.length;
            int minIndex = i;
            for (int j = 0; j < i; j++) {
                if (i-j<=nums[j] && dp[j]<minStep){
                    minIndex = j;
                    minStep = dp[j];
                }
            }
            dp[i] = dp[minIndex]+1;
        }
        return dp[dp.length-1];
    }
    public int jump2(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int end = nums[0];
        int maxPosition = end;
        int ans = 1;
        for (int i = 1; i < nums.length-1; i++) {
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if (i==end){
                ans++;
                end = maxPosition;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        boolean b = canJump.canJump(new int[]{2,3,1,1,4});
        //System.out.println(b);
        int jump = canJump.jump2(new int[]{1, 1, 1, 1, 4});
        System.out.println(jump);
    }
}
