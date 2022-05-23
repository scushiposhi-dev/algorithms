package com.scushiposhi.selectionsort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex= intArray.length-1; lastUnsortedIndex>0; lastUnsortedIndex--){
            int largestIndex=0;
            for (int i=1; i<=lastUnsortedIndex;i++){
                if (intArray[i]>intArray[largestIndex])
                    largestIndex=i;
            }
            swap(intArray,largestIndex,lastUnsortedIndex);
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
