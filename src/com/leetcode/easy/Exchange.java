package com.leetcode.easy;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 * 双指针：头尾分别向中间靠拢
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            // 如果左边奇数右边偶数，指针分别移动
            while(nums[start]%2 != 0 && start<end){
                start++;
            }
            while(nums[end]%2 == 0 && start<end){
                end--;
            }
            if (start<end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Exchange exchange = new Exchange();
        int[] exchange1 = exchange.exchange(new int[]{1, 2, 3, 4, 5});
        for (int i : exchange1) {
            System.out.print(i+" ");
        }
    }
}
