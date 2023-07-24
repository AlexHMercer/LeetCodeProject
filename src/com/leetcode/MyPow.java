package com.leetcode;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * 用快速幂，即将n次幂拆分为两个n/2次幂相乘，并再乘以余数次幂，即
 * x^n = x^(n/2)*x^(n/2)*x^(n%2)
 */
public class MyPow {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n==-1) return 1/x;
        double half = myPow(x,n/2);
        double mod = myPow(x,n%2);
        return half*half*mod;
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double v = myPow.myPow(2.00000, 10);
        System.out.println(v);

    }
}
