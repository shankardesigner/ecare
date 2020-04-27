package com.shankardesigner.ecare.test;

import java.util.Arrays;

public class MergeSortEg {
    public static void main(String[] args) {
        int[] arr = mergeSort(new int[] {5,6,8,25,9,2,18,45,82,62,92,9,26,26,825,62,262,6,52,2,62});
    }

    private static int[] mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length-1);
        return array;
    }

    private static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if(leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array,temp, leftStart, middle);
        mergeSort(array, temp, middle + 1, rightEnd);
        mergeHalves(array, temp, leftStart, rightEnd);
    }

    private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if(array[left] <= array[right]) {
                temp[index] = array[left];
                System.out.println(index  + " -> " + array[left]);
                left ++;
            } else {
                temp[index] = array[right];
                System.out.println(index  + " -> " + array[right]);
                right ++;
            }

            index ++;
        }

        System.arraycopy(array,left, temp, index, leftEnd - left + 1);
//        System.out.println("Left wala sorting " + Arrays.toString(array));
        System.arraycopy(array,right, temp, index, rightEnd - right + 1);
//        System.out.println("Right wala sorting " + Arrays.toString(array));
        System.arraycopy(temp, leftStart, array, leftStart, size);
//        System.out.println("Full Sorting " + Arrays.toString(array));
    }
}
