package com.leetcode;

/**
 * 给定两个字符串text1 和text2，返回这两个字符串的最长公共子序列的长度。
 * 如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的子序列是指这样一个新的字符串：
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 思路：
 * 使用动态规划方法寻找状态转移方程，当字符串1中的第i个字符和字符串2中第j个字符相等时，
 * 那么只需要将i-1和j-1字符串的最长公共子序列长度加1即可。
 * 当字符串1中的第i个字符和字符串2中第j个字符不相等时，
 * 那么就需要检查字符串1添加了第i个字符时与字符串2不添加第j个字符时的公共子序列长度，
 * 和字符串1不添加第i个字符时与字符串2添加第j个字符时的公共子序列长度，哪一个大，就作为都添加了新字符的
 * 最长公共子序列
 * 由此可构建一个二维数组保存字符串1,2的前i个和j个字符的最长公共子序列长度。
 * 当一个字符串为0时，所对应的行或者列值都为0，当两个字符串长度都不为0时，再根据上述方法更新单元格的值。
 *
 * 空间优化：
 * 由于每次更新只需要当前单元格所在行及其上一行的数据，因此二维数组可以简化为两行，
 * 1. 每次执行完一行之后将当前行复制到上一行
 * 2. 在循环时将行数对2取模，即row = i%2; 使行指针在0 1之间跳动
 */

public class longestCommonSubsequence {
    public int max(int x,int y){
        if(x>=y){
            return x;
        }else{
            return y;
        }
    }

    public int solution(String text1, String text2){
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] result = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0 ||j==0){
                    result[i][j] = 0;
                }else{
                    char x = text1.charAt(i-1);
                    char y = text2.charAt(j-1);
                    if(x == y){
                        result[i][j] = result[i-1][j-1]+1;
                    }else{
                        result[i][j] = max(result[i-1][j],result[i][j-1]);
                    }
                }
            }
        }
        return result[len1][len2];
    }

    public static void main(String[] args) {
        longestCommonSubsequence result = new longestCommonSubsequence();
        int ans = result.solution("abcde","ace");
        System.out.println(ans);
    }
}
