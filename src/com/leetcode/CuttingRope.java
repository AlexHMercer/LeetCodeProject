package com.leetcode;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 解：dp：
 * 一根长度为n的绳子切成两段以上的小段，那么可以确定第一段的长度（是1~n-1范围内的值），根据第一段的长度可以确定后面
 * 几段的总长度，则最大乘积，要么是切成两段，要么切成更多段。而如果要切成更多段，由于第一段的长度已经确定，只需要
 * 确定剩下长度的最大乘积再乘上第一段长度即可。因此，要遍历1~n-1范围，找到最大值，即为长度为n时的结果。
 * 又由于计算当前结果需要长度为2~n-1的结果，所以还要遍历1-n，记为dp[i]代表长度为i时的结果。
 */
public class CuttingRope {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=0;
        int max = dp[1];
        for (int i = 2; i <= n; i++) {
            int tempMax = 0;
            for (int j = 1; j <= i-1; j++) {
                tempMax =Math.max(tempMax,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i] = tempMax;
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        CuttingRope cuttingRope = new CuttingRope();
        int i = cuttingRope.cuttingRope(10);
        System.out.println(i);
    }
}
