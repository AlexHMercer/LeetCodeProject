package com.leetcode.easy;

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为5美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，
 * 也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。
 * 如果你能给每位顾客正确找零，返回true，否则返回 false。
 *
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        int len = bills.length;
        for (int i = 0; i < len; i++) {
            switch (bills[i]){
                case 5 :{
                    five++;
                    break;
                }
                case 10 :{
                    ten++;
                    if (five>=1){
                        five--;
                    }else {
                        return false;
                    }
                    break;
                }
                case 20 :{
                    twenty++;
                    if (ten>=1 && five >=1){
                        ten--;
                        five--;
                    }else if (five >=3){
                        five = five - 3;
                    }else{
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange lemonadeChange = new LemonadeChange();
        boolean change = lemonadeChange.lemonadeChange(new int[]{5, 5, 5, 10, 20});
        System.out.println(change);
    }
}
