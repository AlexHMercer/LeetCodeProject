package com.leetcode.easy;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组
 * [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 */

public class MinArray {
    public int minArray(int[] numbers) {
        /**
         * 时间复杂度为n，进阶方法可以考虑二分查找
         */
//        int min = numbers[0];
//        for (int i = 0; i < numbers.length-1; i++) {
//            if (numbers[i+1] >= numbers[i]){
//                continue;
//            }
//            if (numbers[i+1] < numbers[i]){
//                min = Math.min(min,numbers[i+1]);
//            }
//        }
//        return min;
        int left = 0;
        int right = numbers.length-1;
        int mid = 0;
        int min = numbers[0];
        while(left < right){
            mid = (left+right)/2;
            if (numbers[mid] < numbers[right]){
                right = mid-1;
            }else if(numbers[mid] > numbers[right]){
                left = mid+1;
            }else{
                right--;
            }
            min = Math.min(min,numbers[mid]);
        }
        return min;

    }

    public static void main(String[] args) {
        MinArray minArray = new MinArray();
        int i = minArray.minArray(new int[]{2, 2, 2, 0, 1});
        System.out.println(i);
    }
}
