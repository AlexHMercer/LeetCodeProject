package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
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

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        boolean b = canJump.canJump(new int[]{2,3,1,1,4});
        System.out.println(b);

    }
}
