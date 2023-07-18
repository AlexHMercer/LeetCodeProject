package com.leetcode;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 */

public class NConvert {

    public String convert(String s, int numRows) {
        // 特殊情况 numRows==1时
        if (numRows == 1 || s.length() ==1){
            return s;
        }
        // numRows>=2时，先计算每一组的列数
        int col = numRows-2+1;
        // 每一组的数字数量
        int len = 2*numRows-2;
        // 构建结果数组，每个数组中包含一个List
        List[] ans = new List[numRows];
        for (int i=0;i<numRows;i++){
            ans[i] = new LinkedList<Character>();
        }
        // 定义头尾指针
        int start = 0;
        int end = start+len-1;
        while(start<s.length()){
            // 判断尾指针是否越界，如果越界则指定为字符串的尾部节点
            if (end>=s.length()){
                end = s.length()-1;
            }
            // 根据头尾指针截取一组的字符串
            String targetS = s.substring(start,end+1);
            // 将目标字符串分配到指定位置
            int k = numRows-3;
            for (int i = 0; i < targetS.length(); i++) {
                if (i<=numRows-1){
                    ans[i].add(targetS.charAt(i));
                }else {
                    ans[(i+1)%numRows + k].add(targetS.charAt(i));
                    k = k-2;
                }
            }
            start = end+1;
            end = start+len-1;
        }
        String res = "";
        List resList = new LinkedList();
        for (List an : ans) {
            resList.addAll(an);
        }
        return resList.toString().replace("[","").replace("]","");
    }

    public static void main(String[] args) {
        NConvert nConvert = new NConvert();
        String convert = nConvert.convert("ABC", 2);
        System.out.println(convert);

    }
}
