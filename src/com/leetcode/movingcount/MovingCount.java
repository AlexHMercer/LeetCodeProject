package com.leetcode.movingcount;

import java.util.LinkedList;
import java.util.List;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 */
public class MovingCount {
    public int movingCount(int m, int n, int k) {
        // 初始化一个mxn的空数组用来保存可到达的坐标，可到达的记为1，初始全为0
        boolean[][] count = new boolean[m][n];
        if (k == 0){
            return 1;
        }
        int sum = 0;
        // 定义一个队列，辅助进行广度优先搜索
        List<Corrdinate> list = new LinkedList<>();
        list.add(new Corrdinate(0,0));
        int index=0;
        while(list.get(index) != null){
            Corrdinate temp = list.get(index);
            // 判断是否越界，当前是否被访问，是否满足小于k的要求
            if(temp.x<0 || temp.x>m-1 || temp.y<0 || temp.y>n-1
                    || count[temp.x][temp.y] || !isComditional(temp.x,temp.y,k)){
            }else{
                // 当前坐标满足条件，将其置为true
                count[temp.x][temp.y] = true;
                sum = sum+1;
                // 将当前坐标的周围的四个坐标入队
                list.add(new Corrdinate(temp.x+1,temp.y));
                list.add(new Corrdinate(temp.x,temp.y+1));
                list.add(new Corrdinate(temp.x-1,temp.y));
                list.add(new Corrdinate(temp.x,temp.y-1));
            }
            try {
                index++;
                list.get(index);
            }catch (Exception e){
                return sum;
            }
        }
        return sum;
    }

    private boolean isComditional(int x, int y, int k) {
        if (x/10+x%10+y/10+y%10 >k){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        MovingCount movingCount = new MovingCount();
        int i = movingCount.movingCount(2, 3, 1);
        System.out.println(i);
    }
}
