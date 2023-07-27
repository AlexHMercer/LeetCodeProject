package com.leetcode;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
 * 1 翻译成 “b”，……，11 翻译成 “l”，……，25翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 分析：这是一个变相的跳台阶问题，由于一位数和两位数可以各表示一个字母，因此，对于给定的数字num的第i个数字结尾的数字，
 * 可能的组合方式是
 * 1. 第i和i-1个数组能够组合成1~25内的数字，那么第i个数字结尾的数字的结果就是dp[i-1]+dp[i-2]
 * 2. 第i和i-1个数组不能组合成1~25内的数字，那么第i个数字结尾的数字的结果就是dp[i-1]
 *
 */
public class TranslateNum {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            String temp = s.substring(i-2,i);
            if(temp.compareTo("10")>=0 &&temp.compareTo("25")<=0){
                dp[i] = dp[i-1]+dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        int i = translateNum.translateNum(12258);
        System.out.println(i);
    }
}
