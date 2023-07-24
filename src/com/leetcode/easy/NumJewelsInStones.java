package com.leetcode.easy;

import java.util.HashSet;

/**
 * 给你一个字符串 jewels代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
 * stones中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 *
 */
public class NumJewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))){
                sum = sum + 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        NumJewelsInStones numJewelsInStones = new NumJewelsInStones();
        int i = numJewelsInStones.numJewelsInStones("aA", "aAAbbbb");
        System.out.println(i);
    }
}
