package com.leetcode;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 分析：
 *      第一个丑数为1，而其他的所有丑数都可以由当前的丑数乘以2、3、5得到，所以，只需要将当前的丑数分别乘以2、3、5
 *      然后将得到的结果排序即可
 *
 *      关于排序：可以使用三个指针，每个指针代表当前丑数乘以几，每次得到三个指针乘后得到的结果取最小，
 *      最小对应的那个指针，已经使用过了，进行后移即可
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
