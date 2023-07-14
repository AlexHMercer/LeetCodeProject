package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        //排序或者set
//        Set set = new HashSet();
//        int len = nums.length;
//        int ans = 0;
//        for (int i=0;i<len;i++){
//            if (!set.add(nums[i])){
//                ans = nums[i];
//            }else{
//                continue;
//            }
//        }
//        return ans;

        /**
         * 交换对应索引位置的值
         */
        int len = nums.length;
        int ans = 0;
        int i=0;
        while(i<len){
            if (nums[i] == i){
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]){
                ans = nums[i];
                break;
            }
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        int ans = findRepeatNumber.findRepeatNumber(new int[]{3,4,2,1,1,0});
        System.out.println(ans);
    }
}
