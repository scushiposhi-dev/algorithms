package com.scushiposhi.countingsort;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    // NO COMPARISON
    // NON-NEGATIVE NUMBERS (ONLY INTEGERS)
    public static void main(String[] args) {
        int[] intArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};

        countingSort(intArray, 1, 10);
        Arrays.stream(intArray).forEach(System.out::println);
        Stream.of(intArray).forEach(System.out::println);
    }

    private static void countingSort(int[] input, int min, int max) {

        // length of countArray defined considering min and max
        int[] countArray = new int[(max - min) + 1];

        // first step: traverse the input array and for each value
        // count the occurrences incrementing the corresponded index of countArray
        for (int i = 0; i < input.length; i++)
            countArray[input[i] - min]++;

        // second step: write back to the input array
        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}
