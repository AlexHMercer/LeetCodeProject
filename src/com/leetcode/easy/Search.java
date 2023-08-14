package com.leetcode.easy;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 分析：
 *      在已排序的数组中查找，优先考虑二分法
 */
public class Search {
    public int search(int[] nums, int target) {
        int left = 0;
        int ans = 0;
        int right = nums.length-1;
        while(left<= right){
            int mid = (left + right)/2;
            if (nums[mid] == target){
                int i = mid;
                int j = mid;
                while(i>=0 && nums[i] == target) i--;
                while(j <=nums.length-1 && nums[j] == target) j++;
                ans = j-i-1;
                return ans;
            }
            if (nums[mid] < target){
                left = mid + 1;
            }
            if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Search search = new Search();
        int search1 = search.search(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(search1);
    }
}
