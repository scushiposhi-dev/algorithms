package com.scushiposhi.quicksort;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        // call quicksort for intArray

        quicksort(intArray, 0, intArray.length);

        Arrays.stream(intArray).forEach(System.out::println);
    }

    // {20, 35, -15, 7, 55, 1, -22};
    private static void quicksort(int[] input, int start, int end) {

        // check condition for stopping recursion-> only one element
        if (end - start < 2)
            return;


        int pivotIndex = partition(input, start, end);

        // recursive left partition
        quicksort(input, start, pivotIndex);
        // recursive right partition
        quicksort(input, pivotIndex + 1, end);

    }

    // {20, 35, -15, 7, 55, 1, -22};
    private static int partition(int[] input, int start, int end) {

        int i = start; //0
        int j = end; //7
        int pivot = input[start];//20

        // condition for stopping -> when i cross j
        while (i < j) {

            // right to left -> decrement j until the j element is greater than pivot
            // empty loop body
            while (i < j && input[--j] >= pivot) ;
            // check the right cause for breaking while loop -> I found the new index for j element
            if (i < j)
                input[i] = input[j];

            // left to right -> increment i until the i element is less than pivot
            // empty loop body
            while (i < j && input[++i] <= pivot) ;
            // check the right cause for breaking while loop -> I found the new index for the i element
            if (i < j)
                input[j] = input[i];
        }
        // I crossed -> i>j
        input[j] = pivot;
        return j;
    }
}
