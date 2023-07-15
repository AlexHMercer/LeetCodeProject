package com.leetcode;

/**
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案
 *
 */

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        Set<Integer> third = new HashSet<>();

        for (int i=0;i< nums.length-3;i++){
           if (!first.contains(nums[i])){
               first.add(nums[i]);
               for (int j=i+1;j< nums.length-2;j++){
                   if (!second.contains(nums[j])){
                       second.add(nums[j]);
                       for (int k = j+1;k< nums.length-1;k++){
                           if (!third.contains(nums[k])){
                               third.add(nums[k]);
                               int threeSum = nums[i]+nums[j]+nums[k];
                               for (int l = k+1;l< nums.length;l++){
                                   if (threeSum+nums[l] > target){
                                       break;
                                   }
                                   if (threeSum+nums[l] == target){
                                       List<Integer> temp = new ArrayList<>();
                                       temp.add(nums[i]);
                                       temp.add(nums[j]);
                                       temp.add(nums[k]);
                                       temp.add(nums[l]);
                                       res.add(temp);
                                       break;
                                   }
                               }
                           }
                       }
                       third.clear();
                   }
               }
               second.clear();
           }

        }
        return res;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        List<List<Integer>> res = fourSum.fourSum(new int[]{1,0,-1,0,-2,2},0);
        System.out.println(res);
    }
}
