package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。字串一定是连续的。
 */
public class LengthOfLongestSubstring {
    public Boolean noRepeat(String s){
        String as = "12";
        int len = s.length();
        Set<Character> set = new HashSet<>();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                return false;
            }else{
                set.add(c);
            }
        }
        return true;
    }
    public int lengthOfLongestSubstring(String s) {
        /**
         * 超时，上滑动窗口；同时用map来判断
         */
//        int i=0;
//        int length = 1;
//        int ans = 0;
//        while(length <=s.length()){
//            i=0;
//            int j = i+length;
//            while(j<=s.length()){
//                String str = s.substring(i,j);
//                if(noRepeat(str) && str.length()>ans){
//                    ans = str.length();
//                    break;
//                }
//                i++;
//                j = i+length;
//            }
//            length++;
//        }
//        return ans;
        /**
         * 滑动窗口来判断子序列：
         * 使用头指针和尾指针定义一个可滑动的窗口
         * 头指针先不动，尾指针依次向后移动，对每个指向的元素将其放入map集合中。
         * 集合中key为数组中的元素值，value为元素值对应的索引的下一位。
         * 因此，当窗口中没有重复元素时，尾指针逐渐后移，直到遍历完整个String
         * 如果，尾指针发现当前指向的元素在map集合中存在，就是发现了重复的元素，
         * 这时候需要查找和当前尾指针元素相同的窗口中的元素的索引，头指针需要移动到索引的后一位，
         * 同时将尾指针指向元素在map中的value更改为当前尾指针的下一位
         *
         * 这时候，由于发现重复的字符串之前的字串都是不重复的，所以将头指针移动后，去掉了重复元素，留下的序列也是不重复的
         * 尾指针继续按照顺序向后遍历即可。
         */
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int start=0,end=0;end<n;end++){
            Character c = s.charAt(end);
            if (map.containsKey(c)){
                start = Math.max(start,map.get(c));
            }
            ans = Math.max(ans,end-start+1);
            map.put(c,end+1);
        }
        return ans;

    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int i = lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
        System.out.println(i);
    }
}
