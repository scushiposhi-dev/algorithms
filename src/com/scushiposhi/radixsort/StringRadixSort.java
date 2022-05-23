package com.scushiposhi.radixsort;

public class StringRadixSort {

    public static void main(String[] args) {
        String[] radixArray = {"bcdef","dbaqc","abcde","omadd","bbbbb"};


        radixSort(radixArray, 26, 5);

        for (int i = 0; i < radixArray.length; i++) {
            System.out.println(radixArray[i]);
        }
    }

    public static void radixSort(String[] input, int radix, int width) {

        for (int i = width-1; i >=0; i--) {
            radixSingleSort(input, i, radix);
        }

    }

    public static void radixSingleSort(String[] input, int position, int radix) {

        int numItems = input.length;
        int[] countArray = new int[radix];

        // first step: CountingSort algorithm
        for(String value: input)
            countArray[getIndex(position, value)]++;


    // second step: adjust countArray, counting how many values of the digit value or less there are
        // How many values has that digit or less?
        for (int i = 1; i < radix; i++)
            countArray[i] += countArray[i - 1];

        // third step: order values into temporary array starting from the rightmost value
        String[] tmp = new String[numItems];

        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            tmp[--countArray[getIndex(position,input[tempIndex])]] =
                    input[tempIndex];
        }

        // forth step: write back ordered values into input array
        for (int tempIndex = 0; tempIndex < numItems; tempIndex++)
            input[tempIndex] = tmp[tempIndex];


    }

    private static int getIndex(int position, String value) {
        return value.charAt(position) - 'a';
    }

}
