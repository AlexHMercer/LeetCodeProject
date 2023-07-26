package com.leetcode;


/**
 * 给你一个整数数组queries和一个 正整数intLength，请你返回一个数组answer，
 * 其中answer[i] 是长度为intLength的正回文数 中第queries[i]小的数字，如果不存在这样的回文数，则为 -1。
 *
 * 回文数 指的是从前往后和从后往前读一模一样的数字。回文数不能有前导 0 。
 * 分析：
 * 题目要求找长度为intLength的有序回文数中第queries[i]个回文数，而一个回文数可通过前半段决定，
 * 回文数的顺序也可以只通过包含中间那个数的前半段决定。
 * intLength为奇数时，中间一个数，intLength为偶数时，中间两个数，但是中间的两个数必须相同。
 * 因此偶数时的回文数结果只是比奇数时多一位尾数。因此对每一个偶数，可以先计算他前一个奇数的回文数的一半。
 *
 * 最后，回文数的排序取决于回文数包含中间数的一半的长度，由于第一位不能为0，
 * 所以一半的长度为n时，范围应该是10^(n-1)~10^n - 1；然后再根据是不是偶数，把当前数值翻转并拼接到后面。
 */
public class KthPalindrome {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] ans = new long[queries.length];
        if (intLength == 1){
            for (int i = 0; i < queries.length; i++) {
                if (queries[i]<=9){
                    ans[i] = queries[i];
                }else{
                    ans[i] = -1;
                }
            }
            return ans;
        }
        boolean isEven = false;
        // 首先看length是奇数还是偶数
        if (intLength % 2 ==0){
            isEven = true;
            intLength = intLength - 1;
        }
        // 计算回文数包含中间值的长度
        int halfLength = 1+(intLength-1)/2;
        // 计算回文数范围，包括起始值和终止值
        long start = (long)Math.pow(10,halfLength-1);
        long end = (long)Math.pow(10,halfLength)-1;
        // 遍历querise，看querise[i]+start-1是否位于start~end中
        for (int i = 0; i < queries.length; i++) {
            if (start + queries[i]-1 <= end){
                ans[i] = completePalindrome(start + queries[i]-1,isEven);
            }else {
                ans[i] = -1;
            }
        }
        return ans;
        
    }

    private long completePalindrome(long l, boolean isEven) {
        String s = String.valueOf(l);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        if (isEven){
            for (int i = s.length()-1; i >=0; i--) {
                stringBuilder.append(s.charAt(i));
            }
        }else{
            for (int i = s.length()-2; i >=0; i--) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return Long.parseLong(stringBuilder.toString());
    }

    public static void main(String[] args) {
        KthPalindrome kthPalindrome = new KthPalindrome();
        long[] longs = kthPalindrome.kthPalindrome(new int[]{2, 4, 6}, 4);
        for (long aLong : longs) {
            System.out.println(aLong);
        }
    }
}
