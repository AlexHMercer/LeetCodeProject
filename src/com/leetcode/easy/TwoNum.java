package com.leetcode.easy;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出
 * 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 */
public class TwoNum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i< nums.length;i++){
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                ans[0] = map.get(temp);
                ans[1] = i;
            }
            // 可以一边放一边求，遍历到前一个数字时，后一个数字还没放进去，则先把前一个数字放进去，
            // 等到遍历到后面的数字时，数字和target之间的差可以在map里查找到，
            // 则直接把map里的值的索引和当前值的索引输出

            map.put(nums[i],i);
        }
        return ans;
    }

    public static void main(String[] args) {
        TwoNum twoNum = new TwoNum();
        int[] ints = twoNum.twoSum(new int[]{3, 3}, 6);
        System.out.println(ints[0]+" "+ints[1]);
    }
}
