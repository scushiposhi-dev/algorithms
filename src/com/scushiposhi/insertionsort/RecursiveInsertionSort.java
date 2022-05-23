package com.scushiposhi.insertionsort;

import java.util.Arrays;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};


        insertionSort(intArray, intArray.length);

        Arrays.stream(intArray).forEach(System.out::println);

    }

    public static void insertionSort(int[] input, int numItems) {
        // condition for breaking recursion
        if (numItems <2)
            return;

        insertionSort(input,numItems-1);

        int newElement = input[numItems-1];
        int i;

        for (i = numItems-1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }
        input[i] = newElement;
    }

}
