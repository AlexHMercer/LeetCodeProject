package com.leetcode.hard;

import java.util.Arrays;
import java.util.LinkedList;

public class Trap {
    public int trap(int[] height) {
        // 定义头指针，数组长度
        int len = height.length;
        if (len == 1){
            return 0;
        }
        int start = 0;
        // 做预处理，将尾部的递减的元素从height中去掉
        for (int i = len-1; i >0 ; i--) {
            if (height[i]<=height[i-1]){
                height = Arrays.copyOfRange(height,0,i);
            }else{
                break;
            }
        }
        len = height.length;

        int sumWaterV = 0;
        // 头指针不超过数组长度时继续循环
        while (start<len){
            // 若头指针指向最后一个元素，尾指针直接越界时，直接break
            if (start+1>=len){
                break;
            }
            int tempMax = height[start];
            int elseMax = height[start+1];
            for (int i = start+1; i < len ; i++) {
                tempMax = Math.max(tempMax,height[i]);
                elseMax = Math.max(elseMax,height[i]);
            }
            if (tempMax == height[start]){
                height[start] = elseMax;
            }
            // 定义尾指针
            int end = start+1;


            // 当尾指针不越界，且尾指针指向的数组元素小于头指针时，将尾指针后移
            // end<len-1，是为了保证end不越界
            while (end < len-1 && height[end]<height[start]){
                end++;
            }
            // 如果，第一个值就是整个数组的最大值，那么，要把这个值换成剩下值中的最大值


            /**
             * 写的不对，在进行预处理后，就不需要考虑这种情况了
             * end移动到边界，start~end可能不递减，可能中间有空间
             */
            // 处理特殊情况，即end移动到边界，且start~end递减，此时不能存水，
            // 也就是end指向的值为start~end的最小值时
//            int startToEndMin = height[start];
//            for (int i = start; i <= end; i++) {
//                startToEndMin = Math.min(startToEndMin,height[i]);
//            }
//            if (startToEndMin == height[end] && end == len-1){
//                sumWaterV = sumWaterV + this.trap(Arrays.copyOfRange(height,start,end));
//                break;
//            }
            // 尾指针移动完成后，头尾指针定义了一个存储水的区域，首先计算区域总体积，然后减去中间的墙的体积，
            // 即是对应的可存储水的体积
            int min = Math.min(height[end],height[start]);// 这个min是头尾指针对应元素的最小值
            int sumVolume = min*(end-start+1);
            // 循环减去中间墙的体积
            for (int i = start; i <= end; i++) {
                int vol = Math.min(min,height[i]);
                sumVolume = sumVolume - vol;
            }
            sumWaterV = sumWaterV + sumVolume;
            start = end;
        }
        return sumWaterV;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int trap1 = trap.trap(new int[]{2,6,3,8,2,7,2,5,0});
        System.out.println(trap1);
    }
}
