package com.leetcode;



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
