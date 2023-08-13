package com.leetcode.easy;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，
 * nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * 分析：
 *      与链表不同，数组的节点插入较为复杂，如果按照链表的思路，从前往后插入，就必须进行若干次移位，极为耗时
 *      但是，本题数组nums1给出了足够的空间，因此可以转换思路，从后往前，先插入最大的节点，再依次前移
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end1 = m-1;
        int end2 = n-1;
        int right = m+n-1;
        while(end1>=0 && end2>=0){
            if (nums1[end1] >= nums2[end2]){
                nums1[right] = nums1[end1];
                end1--;
            }else if (nums1[end1] < nums2[end2]){
                nums1[right] = nums2[end2];
                end2--;
            }
            right--;
        }
        while(end1 >= 0 ){
            nums1[right] = nums1[end1];
            right--;
            end1--;
        }
        while(end2 >= 0 ){
            nums1[right] = nums2[end2];
            right--;
            end2--;
        }
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] ints = new int[]{1,2,3,0,0,0};
        merge.merge(ints,3,new int[]{2,5,6},3);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}
