package com.leetcode;

import java.util.LinkedList;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * 分析：用一个栈来检查，当栈顶元素与出栈序列指针所指向元素不同时，新的元素入栈，相同时出栈
 * 两数组指针都指向最后的越界位置时，返回true，若只是入栈指针越界，返回false
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 两个数组的遍历指针
        int i = 0;
        int j = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        while(i< pushed.length || j < popped.length){
            if ( stack.isEmpty() || !stack.peek().equals(popped[j])){
                if (i == pushed.length){
                    return false;
                }
                stack.push(pushed[i]);
                i++;
            }
            if (stack.peek().equals(popped[j])){
                stack.pop();
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        boolean b = validateStackSequences.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4,3,5,1,2});
        System.out.println(b);
    }
}
