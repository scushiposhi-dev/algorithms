package com.scushiposhi.shellsort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        // once defined the gap, traverse until gap=1, that becomes InsertionSort
        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {

            //traverse the array starting from gap index towards right side
            for (int i = gap; i < intArray.length; i++) {

                int newElement = intArray[i];// the insertion value

                //compare value(first index is gap) against valueIndex-gap until is not over first index (left side)
                int j = i;
                // traverse the array using j towards left side
                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }
                intArray[j] = newElement;
            }
        }
        Arrays.stream(intArray).forEach(System.out::println);

    }
}
