package com.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * n 个朋友在玩游戏。这些朋友坐成一个圈，按 顺时针方向 从 1 到 n 编号。从第 i 个朋友的位置开始顺时针移动 1 步会到达第 (i + 1) 个朋友的位置（1 <= i < n），而从第 n 个朋友的位置开始顺时针移动 1 步会回到第 1 个朋友的位置。
 *
 * 游戏规则如下：
 *
 * 第 1 个朋友接球。
 *
 * 接着，第 1 个朋友将球传给距离他顺时针方向 k 步的朋友。
 * 然后，接球的朋友应该把球传给距离他顺时针方向 2 * k 步的朋友。
 * 接着，接球的朋友应该把球传给距离他顺时针方向 3 * k 步的朋友，以此类推。
 * 换句话说，在第 i 轮中持有球的那位朋友需要将球传递给距离他顺时针方向 i * k 步的朋友。
 *
 * 当某个朋友第 2 次接到球时，游戏结束。
 *
 * 在整场游戏中没有接到过球的朋友是 输家 。
 */
public class CircularGameLosers {
    public int[] circularGameLosers(int n, int k) {
        HashMap<Integer, Integer> ball = new HashMap<>();
        // 将所有人的初始接球次数置为0
        for (int i = 1; i <= n; i++) {
            ball.put(i,0);
        }
        // 当前持球的人
        int currentBallIndex = 1;
        int round = 1;
        ball.put(1,1);
        while (ball.get(currentBallIndex) != 2){
            // 持球人变更
            int temp = (currentBallIndex + round * k) % n;
            if (temp == 0) currentBallIndex = n;
            else currentBallIndex = temp;
            ball.put(currentBallIndex,ball.get(currentBallIndex)+1);
            round++;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (ball.get(i) == 0){
                integers.add(i);
            }
        }
        return integers.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        CircularGameLosers circularGameLosers = new CircularGameLosers();
        int[] ints = circularGameLosers.circularGameLosers(1, 1);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}
