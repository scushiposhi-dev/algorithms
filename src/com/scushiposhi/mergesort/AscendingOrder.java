package com.scushiposhi.mergesort;

import java.util.Arrays;

public class AscendingOrder {

    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        Arrays.sort(intArray);
        //call mergeSort for intArray
        mergeSort(intArray, 0, intArray.length);

        //print sorted array
        Arrays.stream(intArray).forEach(System.out::println);
    }

    private static void mergeSort(int[] intArray, int start, int end) {

        // break recursive function when I have single element
        if (end - start < 2)
            return;

        // find midpoint to split array in to partition (left partition,right partition)
        int midpoint = (start + end) / 2;

        // recursive left partition
        mergeSort(intArray, start, midpoint);

        // recursive right partition
        mergeSort(intArray, midpoint, end);

        merge(intArray, start, midpoint, end);
    }

    //{20, 35, -15, 7, 55, 1, -22};
    private static void merge(int[] input, int start, int mid, int end) {

        // break merging when left is less than right
        if (input[mid - 1] <= input[mid])
            return;

        // i to traverse left partition
        int i = start;
        // j to traverse right partition
        int j = mid;
        // tmpArray length is not the length of input array
        int[] tmpArray = new int[end - start];
        // tmpIndex to traverse tmpArray array
        int tmpIndex = 0;

        // check until i or j finish traversing partitions
        //{-15, 20, 35}{-22, 1, 7, 55};
        while (i < mid && j < end) {
            // STABLE <= 989 WILL BE 899 BUT THE LAST 9 NEVER SWAP WITH THE PREVIOUS 9
            // i=0, j=3 -> tmpArray = {-22}
            // i=0, j=4 -> tmpArray = {-22,-15}
            // i=1, j=4 -> tmpArray = {-22,-15,1}
            // i=1, j=5 -> tmpArray = {-22,-15,1,7}
            // i=1, j=6 -> tmpArray = {-22,-15,1,7,20}
            // i=2, j=6 -> tmpArray = {-22,-15,1,7,20,35}
            // i=3, j=6 -> step out because 55 is missing
            tmpArray[tmpIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
            //{35,-15} -> input[i]<=input[j]?
            // i index of 35 it means that tmpArray will contain -15 (j index) and i will not increment but j and tmpIndex yes
            // 35 is missing
        }


        //System.arraycopy(Object src, int beginningPos,Object dest,int beginningDestPos,int numberOfElementsToCopy);
        // i is index of 35 and I need to save it at the correct position -> start+tmpIndex(tmpIndex has been already incremented)
        //when all array mid-i=1
        System.arraycopy(input, i, input, start + tmpIndex, mid - i);
        //in this way i need to copy only the elements on the left side that are already saved inside tmpIndex
        System.arraycopy(tmpArray, 0, input, start, tmpIndex);
    }
}
