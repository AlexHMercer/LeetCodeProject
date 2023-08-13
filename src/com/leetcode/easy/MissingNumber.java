package com.leetcode.easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        // 时间复杂度O(N)
        if(nums[0] != 0) return 0;
        int ans = -1;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]+1 != nums[i+1]){
                ans = nums[i]+1;
            }
        }
        return ans == -1?nums.length:ans;
    }

    /**
     * TODO:对有序数组的查找而言，应该优先想二分法
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        // 时间复杂度O(logn)
        // TODO：在一个排序后的数组中，每个元素应该与索引相等，要查找的元素是与索引不相等的元素，
        //  则中间元素与索引相等时，要查找的元素一定在右边，中间元素与与索引不相等时，要查找的元素一定在左边
        //  最后应该返回的应该是索引值

        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
