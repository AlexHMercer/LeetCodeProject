package com.quicksort;

public class QuickSort {
    public int[] quickSort(int[] arr){
        int left = 0;
        int right = arr.length-1;
        arr = invokeQuickSort(arr,left,right);
        return arr;
    }

    private int[] invokeQuickSort(int[] arr, int left, int right) {
        int mid = arr[left];
        int start = left;
        int end = right;
        while(left < right){
            while(left < right && arr[left]<mid){
                left++;
            }
            while(left < right && arr[right]>mid){
                right--;
            }
            if (left < right && arr[left] == arr[right]){
                left++;
            }else{
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        if (start<left-1){
            arr = invokeQuickSort(arr,start,left-1);
        }
        if (end > right+1){
            arr = invokeQuickSort(arr,right+1,end);
        }
        return arr;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] ints = quickSort.quickSort(new int[]{5, 6, 3, 4, 8, 9});
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}
