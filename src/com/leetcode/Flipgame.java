package com.leetcode;

import java.util.HashSet;

/**
 * 在桌子上有 n 张卡片，每张卡片的正面和背面都写着一个正数（正面与背面上的数有可能不一样）。
 *
 * 我们可以先翻转任意张卡片，然后选择其中一张卡片。
 *
 * 如果选中的那张卡片背面的数字 x 与任意一张卡片的正面的数字都不同，那么这个数字是我们想要的数字。
 *
 * 哪个数是这些想要的数字中最小的数（找到这些数中的最小值）呢？如果没有一个数字符合要求的，输出 0 。
 */
public class Flipgame {
    public int flipgame(int[] fronts, int[] backs) {
        // 用于存放双面都一样的位置
        HashSet<Integer> integers = new HashSet<>();
        int len = fronts.length;
        for (int i = 0; i < len; i++) {
            if(fronts[i] == backs[i]){
                integers.add(fronts[i]);
            }
        }
        int ans = 3000;
        for (int i = 0; i < len; i++) {
            if (!integers.contains(fronts[i])){
                ans = Math.min(ans,fronts[i]);
            }
            if (!integers.contains(backs[i])){
                ans = Math.min(ans,backs[i]);
            }
        }
        return ans%3000;
    }

    public static void main(String[] args) {
        Flipgame flipgame = new Flipgame();
        int flipgame1 = flipgame.flipgame(new int[]{1}, new int[]{1});
        System.out.println(flipgame1);
    }
}
