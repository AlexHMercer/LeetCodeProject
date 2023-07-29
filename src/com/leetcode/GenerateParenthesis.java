package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 分析:dp
 * 对n个括号能组成的所有合法排序而言，最左边一个字符一定是(，而其一定有一个对应的)，当把这一对括号去掉之后
 * 剩下的括号就只有n-1对了而这n-1对的括号，可能有j对在去掉的括号之内，k=n-1-j对在去掉的括号之外（0<=j<=n-1）
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        if (n == 0){
            return null;
        }
        LinkedList<LinkedList<String>> linkedLists = new LinkedList<>();
        // 将n=0和n=1的值放进去
        LinkedList<String> list0 = new LinkedList<>();
        list0.add("");
        linkedLists.add(list0);
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("()");
        linkedLists.add(list1);
        // 根据0 1 从2开始，填充list
        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<>();
            for (int j = 0; j <= i-1; j++) {
                // 提取linkedLists对应位置的括号的所有可能
                LinkedList<String> listJ = linkedLists.get(j);
                LinkedList<String> listK = linkedLists.get(i - 1 - j);
                // 遍历listJ和listK，将listJ的内容放在（）里面，listK的内容放在括号外面
                for (String sj : listJ) {
                    for (String sk : listK) {
                        temp.add("("+sj+")"+sk);
                    }
                }
            }
            linkedLists.add(temp);
        }
        return linkedLists.get(n);
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(1);
    }
}
