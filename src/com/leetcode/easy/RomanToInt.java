package com.leetcode.easy;

import java.util.HashMap;

public class RomanToInt {
    public int romanToInt(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = map.get(s.charAt(i));
            try {
                int num1 = map.get(s.charAt(i+1));
                if (num < num1){
                    ans = ans - num;
                }else{
                    ans = ans + num;
                }
            }catch (Exception e){
                ans = ans +num;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        int iii = romanToInt.romanToInt("I");
        System.out.println(iii);
    }

}
