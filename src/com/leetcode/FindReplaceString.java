package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 你会得到一个字符串 s (索引从 0 开始)，你必须对它执行 k 个替换操作。
 * 替换操作以三个长度均为 k 的并行数组给出：indices, sources,  targets。
 *
 * 要完成第 i 个替换操作:
 *
 * 1. 检查 子字符串  sources[i] 是否出现在 原字符串 s 的索引 indices[i] 处。
 * 2. 如果没有出现， 什么也不做 。
 * 3. 如果出现，则用 targets[i] 替换 该子字符串。
 * 分析：
 *      见注释
 */
public class FindReplaceString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        // 由于indices是乱序的，所以要构建两个map，保存每个索引对应的串，后面再对indices排序
        HashMap<Integer, String> sourceMap = new HashMap<>();
        HashMap<Integer, String> targetMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder(s);
        int n = indices.length;
        for (int i = 0; i < n; i++) {
            sourceMap.put(indices[i],sources[i]);
            targetMap.put(indices[i],targets[i]);
        }
        // 排序
        Arrays.sort(indices);
        // 从前往后替换时，替换过的字符串会影响原有字符串的长度，所以要在替换完成之后计算相对于原本的字符串，
        // 新的串增加或减少了多少长度
        int tempIndex = 0;
        for (int i = 0; i < n; i++) {
            int index = indices[i]+tempIndex;
            int sourceLen = sourceMap.get(indices[i]).length();
            int targetLen = targetMap.get(indices[i]).length();
            if (stringBuilder.substring(index,index+sourceLen).equals(sourceMap.get(indices[i]))){
                // StringBuilder可以根据索引进行替换
                stringBuilder.replace(index,index+sourceLen,targetMap.get(indices[i]));
                tempIndex = tempIndex + targetLen-sourceLen;
            }else {
                continue;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        FindReplaceString findReplaceString = new FindReplaceString();
        String abcd = findReplaceString
                .findReplaceString("vmokgggqzp", new int[]{3,5,1}, new String[]{"kg", "ggq","mo"},
                                    new String[]{"s", "so","bfr"});
        System.out.println(abcd);
    }
}
