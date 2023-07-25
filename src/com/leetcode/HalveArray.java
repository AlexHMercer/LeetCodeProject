package com.leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 给你一个正整数数组nums。每一次操作中，你可以从nums中选择 任意一个数并将它减小到 恰好一半。
 * （注意，在后续操作中你可以对减半过的数继续执行操作）
 *
 * 请你返回将 nums数组和 至少减少一半的 最少操作数。
 *
 * 思路很简单，每次找出最大的值，将其减半，看是否满足整体数组至少减少一半的条件。
 * 每次选择最大值的方式，使用优先队列。
 * 优先队列是一个加入了优先级的队列，每次出队的数据是优先级最高或最低的那个。
 * java中给出了优先队列的实现，PriorityQueue，其实现了Queue接口，底层默认是小根堆，
 * 可以通过创建时传入比较器将其转化为大根堆
 */
public class HalveArray {

    public int halveArray(int[] nums) {
        // 建立一个优先队列
        // Collections.reverseOrder()按照自然顺序的反序返回一个比较器
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        // 计算nums的和
        double numsSum = 0;
        // 操作次数
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer((double)nums[i]);
            numsSum =numsSum + nums[i];
        }
        // 计算需要减去的最小值
        numsSum = numsSum/2;
        while (numsSum>0){
            double temp = priorityQueue.poll();
            numsSum = numsSum - temp/2;
            priorityQueue.add(temp/2);
            num = num + 1;
        }
        return num;
    }

    public static void main(String[] args) {
        HalveArray halveArray = new HalveArray();
        int i = halveArray.halveArray(new int[]{3,8,20});
        System.out.println(i);
    }
}
