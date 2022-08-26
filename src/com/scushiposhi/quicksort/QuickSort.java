package com.scushiposhi.quicksort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,2};
        quickSort(array);
        Arrays.stream(array).forEach(System.out::println);
        System.out.println("rotto");
    }

    public static int[] quickSort(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    public static int[] quickSort(int[] array, int start, int end) {
        if (end - start <= 0)
            return array;

        int pivotIndex = getPivotIndex(array, start, end);

        // left subarray
        quickSort(array, start, pivotIndex - 1);
        // right subarray
        quickSort(array, pivotIndex + 1, end);

        return array;
    }

    public static int getPivotIndex(int[] array, int start, int end) {

        int pivotIdx=start;
        int leftIdx=start+1;
        int rightIdx=end;
        int pivot=array[pivotIdx];

        while (leftIdx <= rightIdx) {
            if (array[leftIdx] > pivot && array[rightIdx] < pivot) {
                swap(array, leftIdx, rightIdx);
                leftIdx++;
                rightIdx--;
                continue;
            }
            if (array[leftIdx] <= pivot)
                leftIdx++;
            if (array[rightIdx] >= pivot)
                rightIdx--;
        }
        // the right index has crossed the left index(or the contrary ), this means that the right become less than pivot and left will be greater than pivot
        swap(array, rightIdx, pivotIdx);
        return rightIdx;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

