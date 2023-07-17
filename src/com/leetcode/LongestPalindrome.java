package com.leetcode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        // 长度为1一定是字串
        if (len ==1){
            return s;
        }
        // 定义状态转移矩阵
        int[][] dp = new int[len][len];
        // 将长度为1的字串的坐标置为1
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        // 定义最大长度
        int max = 1;
        // 定义头指针和
        int start = 0;

        // 根据字串长度进行dp
        for (int L = 2;L <= len;L++){
            // 确定字串的起始位置
            for (int i=0;i<len;i++){
                int j = L+i-1; // 找尾指针
                // 判断尾指针是否越界
                if (j>len-1){
                    break;
                }
                // 判断当前的头尾元素是否相等
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = 0;
                }else{
                    // 若头尾字符相等，则需要判断当前子串长度是否为3或3以下。
                    // 因为只有子串长度大于等于4时，才能用头尾指针各缩进一位进行判断。
                    if (L == 2){
                        dp[i][j] = 2;
                    }else{
                        if(dp[i+1][j-1] !=0 ){
                            dp[i][j] = dp[i+1][j-1]+2;
                        }
                    }
                }
                if(dp[i][j]>max){
                    start = i;
                    max = L;
                }
            }
        }
        return s.substring(start,start+max);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String ababa = longestPalindrome.longestPalindrome("aacabdkacaa");
        System.out.println(ababa);
    }
}
