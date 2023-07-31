package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 解析：
 *
 */
public class Permutation {
    // 存放结果
    List<String> res;
    // 标记元素是否被访问
    boolean[] vis;
    public String[] permutation(String s) {
        res = new ArrayList<>();
        vis = new boolean[s.length()];
        // 把s转化为数组并排序
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuffer stringBuffer = new StringBuffer();
        backtrack(chars,0,stringBuffer);

        // 将res中的结果存放到数组中
        String[] strings = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            strings[i] = res.get(i);
        }
        return strings;
    }

    private void backtrack(char[] chars, int i, StringBuffer stringBuffer) {
        if (i == chars.length){
            res.add(stringBuffer.toString());
            return;
        }
        // 查抄chars，看当前字符是否能放到string里
        for (int j = 0; j < chars.length; j++) {
            if(vis[j]||(j>0 && !vis[j-1] && chars[j-1] == chars[j])){
                continue;
            }
            vis[j] = true;
            stringBuffer.append(chars[j]);
            backtrack(chars, i+1, stringBuffer);
            vis[j] = false;
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
    }

    public static void main(String[] args) {

        Permutation permutation = new Permutation();
        String[] abcs = permutation.permutation("aab");
        for (String abc : abcs) {
            System.out.print(abc+" ");
        }
    }
}
