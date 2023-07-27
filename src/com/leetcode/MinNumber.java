package com.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 分析：
 *      本质是个排序问题，但是需要证明。（还没看.jpg）
 *      结论是：当数组中所有的元素满足a+b<b+a时，数组中的元素依次加入字符串就是应得的结果。
 *      a+b < b+a中，+为字符串拼接运算，即[3,30]中，a+b=330，b+a=303，因为a+b > b+a，所以a,b位置需要对调。
 *
 * 注：需要查看队列中Comparator的用法。
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        // 此处可替换为lambda表达式
//        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o1+o2).compareTo(o2+o1);
//            }
//        });
        PriorityQueue<String> queue = new PriorityQueue<>(((o1, o2) -> (o1+o2).compareTo(o2+o1)));
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            queue.offer(String.valueOf(num));
        }
        while (queue.peek() != null){
            stringBuilder.append(queue.poll());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MinNumber minNumber = new MinNumber();
        String s = minNumber.minNumber(new int[]{3,30,34,5,9});
        System.out.println(s);
    }
}
