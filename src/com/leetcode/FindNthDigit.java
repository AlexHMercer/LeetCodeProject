package com.leetcode;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        if (n<10){
            return n;
        }
        int i=1;
        while(true){
            if (n-(i*Math.pow(10,i-1)*9) > 0){
                n = n - (i*(int)Math.pow(10,i-1)*9);
                i++;
                continue;
            }
            if (n-(i*Math.pow(10,i-1)*9) == 0){
                String s = String.valueOf((int)Math.pow(10,i)-1);
                return s.charAt(s.length() - 1)-48;
            }
            if (n-(i*Math.pow(10,i-1)*9) < 0){
                int start = (int)Math.pow(10,i-1);
                if (n%i == 0){
                    start = start + (n/i) - 1;
                    String s = String.valueOf(start);
                    return s.charAt(s.length()-1)-48;
                }
                if (n%i != 0){
                    start = start + (n/i);
                    String s = String.valueOf(start);
                    return s.charAt(n%i-1)-48;
                }
            }
        }
    }

    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        int nthDigit = findNthDigit.findNthDigit(15);
        System.out.println(nthDigit);
    }
}
