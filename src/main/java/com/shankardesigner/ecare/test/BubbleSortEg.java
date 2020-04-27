package com.shankardesigner.ecare.test;

import java.util.Arrays;

public class BubbleSortEg {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int[] bubbleSort(int [] array) {
        boolean isSorted = false;
        int lastUnsorted = array.length - 1;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < lastUnsorted; i ++) {
                if(array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }

            lastUnsorted --;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] arr = {6,7,3,2,1,9,4};
        int[] sortedArray = bubbleSort(arr);

        System.out.println(Arrays.toString(sortedArray));
    }
}
