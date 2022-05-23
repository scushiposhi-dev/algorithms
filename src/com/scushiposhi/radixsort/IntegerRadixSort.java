package com.scushiposhi.radixsort;

public class IntegerRadixSort {

    public static void main(String[] args) {
        // only integers and strings
        // same radix = 10 -> number of possibilities: 10 for integers (0-9), 26 for English alphabet..
        // same width = 4  -> number of digits: 4 for 1598, 5 for 58712..
        int[] radixArray = {4725, 4586, 1330, 8792, 1594, 5729};


        radixSort(radixArray, 10, 4);

        for (int i = 0; i < radixArray.length; i++) {
            System.out.println(radixArray[i]);
        }
    }

    public static void radixSort(int[] input, int radix, int width) {

        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }

    }

    public static void radixSingleSort(int[] input, int position, int radix) {

        int numItems = input.length;
        int[] countArray = new int[radix];

        // first step: CountingSort algorithm
        for (int value : input) {
            countArray[getDigit(value, position, radix)]++;
        }

        // second step: adjust countArray, counting how many values of the digit value or less there are
        // How many values has that digit or less?
        for (int i = 1; i < radix; i++) {
            countArray[i] += countArray[i - 1];
        }

        // third step: order values into temporary array starting from the rightmost value
        int[] tmp = new int[numItems];

        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            tmp[--countArray[getDigit(input[tempIndex], position, radix)]] =
                    input[tempIndex];
        }

        // forth step: write back ordered values into input array
        for (int tempIndex = 0; tempIndex < numItems; tempIndex++)
            input[tempIndex] = tmp[tempIndex];


    }

    //4875 -> position=2, radix=10 -> return (4785/10^2)%10 = 8
    public static int getDigit(int value, int position, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }
}
