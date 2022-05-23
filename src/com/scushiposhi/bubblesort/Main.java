package com.scushiposhi.bubblesort;

import java.util.Arrays;

public class Main {
// Big O - > O(n^2) quadratic time complexity,  bad
    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for(int lastUnsortedIndex=intArray.length-1;lastUnsortedIndex>0;lastUnsortedIndex--){
            for (int i=0;i<lastUnsortedIndex;i++){
                if (intArray[i]>intArray[i+1])
                    swap(intArray,i,i+1);
            }
        }

        Arrays.stream(intArray).forEach(System.out::println);

    }

    public static void swap(int[] array, int i, int j) {

        if (i == j)
            return;

        int tempI = array[i];
        array[i] = array[j];
        array[j] = tempI;

    }
}
