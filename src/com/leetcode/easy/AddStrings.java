package com.leetcode.easy;

/**
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 *
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
//        int i=num1.length();
//        int j=num2.length();
//        if (i>j){
//            int t = i;
//            i = j;
//            j = t;
//            String st = num2;
//            num2 = num1;
//            num1 = st;
//        }
//        int dis = Math.abs(i-j);
//        int jinwei = 0;
//        String ans = "";
//        for (i = i-1,j = j-1;j>=0;i--,j--){
//            if (i<0){
//                int num2c = (int)num2.charAt(j)-48;
//                int temp = num2c + jinwei;
//                ans = temp%10 + ans;
//                jinwei = temp/10;
//                if (j==0 && jinwei !=0){
//                    ans = jinwei+ans;
//                }
//                continue;
//            }
//           int num1c = (int)num1.charAt(i)-48;
//           int num2c = (int)num2.charAt(j)-48;
//           int temp = num1c + num2c + jinwei;
//           ans = temp%10 + ans;
//           jinwei = temp/10;
//           if (j==0 && jinwei !=0){
//               ans = jinwei+ans;
//           }
//
//        }
//        return ans;

        /**
         * 太复杂，改用while
         */
        int i=num1.length()-1;
        int j=num2.length()-1;
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        while(i>=0 || j>=0 || carry>0){
            if(i>=0){
                carry = carry+(int)num1.charAt(i)-48;
            }
            if(j>=0){
                carry = carry+(int)num2.charAt(j)-48;
            }
            builder.append(carry%10);
            carry = carry/10;
            i--;
            j--;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        String s = addStrings.addStrings("1", "9");
        System.out.println(s);

    }
}
