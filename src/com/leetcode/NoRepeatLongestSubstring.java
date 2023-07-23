package com.leetcode;

import java.util.HashMap;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */

public class NoRepeatLongestSubstring {

    public int noRepeatLongestSubstring(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int start = 0;
        int end = 0;
        int maxLength = 0;
        while(end < len){
            if(map.containsKey(s.charAt(end))){
                start = Math.max(start,map.get(s.charAt(end))+1);
            }
            map.put(s.charAt(end),end);
            maxLength = Math.max(maxLength,end-start+1);
            end++;

        }
        return maxLength;
    }

    public static void main(String[] args) {
        NoRepeatLongestSubstring substring = new NoRepeatLongestSubstring();
        int i = substring.noRepeatLongestSubstring("tmmzuxt");
        System.out.println(i);
    }
}
