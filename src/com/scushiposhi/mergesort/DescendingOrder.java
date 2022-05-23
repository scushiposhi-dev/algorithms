package com.scushiposhi.mergesort;

import java.util.Arrays;

public class DescendingOrder {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        //call mergeSort -> must order couples of elements or single
        mergeSort(intArray, 0, intArray.length);

        Arrays.stream(intArray).forEach(System.out::println);
    }

    private static void mergeSort(int[] input, int start, int end) {
        // 1 element -> condition for stopping recursion
        if (end - start < 2)
            return;

        int midpoint = (end + start) / 2;
        //splitting recursion left side
        mergeSort(input, start, midpoint);

        //splitting recursion right side
        mergeSort(input, midpoint, end);

        merge(input, start, midpoint, end);
    }

    private static void merge(int[] input, int start, int midpoint, int end) {

        // condition for stopping merge recursion, already ordered
        if (input[midpoint - 1] >= input[midpoint])
            return;
        // index i for traversing left side
        int i = start;

        // index j for traversing right side
        int j = midpoint;

        // temporary array, length as I want to order
        int[] tmpArray = new int[end - start];
        //index tmpIndex for traversing tmpArray
        int tmpIndex=0;

        // condition: when index i finish traversing left side or j right side
        //stable <=
        while(i < midpoint && j < end)
            // {35,-15} -> tmpArray={35} and 15 is missing but still in input
            tmpArray[tmpIndex++]=input[i]>=input[j]?input[i++]:input[j++];

        // i is not incremented, it means that it still has the index of the missing element
        //copy the left element that is missing and not present in tmpArray

        System.arraycopy(input,i,input,start+tmpIndex,midpoint-i);
        System.arraycopy(tmpArray,0,input,start,tmpIndex);
    }
}
