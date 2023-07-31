package com.leetcode.easy;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 注：本题可使用摩尔投票法，将空间复杂度降低到O(1)
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
            if (1+nums.length/2 <= map.get(nums[i])){
                ans = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int i = majorityElement.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
        System.out.println(i);
    }
}
