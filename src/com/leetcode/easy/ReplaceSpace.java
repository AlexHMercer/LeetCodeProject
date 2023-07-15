package com.leetcode.easy;

public class ReplaceSpace {
    public String replaceSpace(String s){
        return s.replace(" ","%20");
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String s = replaceSpace.replaceSpace("Hello Word");
        System.out.println(s);
    }
}
