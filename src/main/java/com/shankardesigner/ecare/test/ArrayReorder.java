package com.shankardesigner.ecare.test;

import java.util.Arrays;

public class ArrayReorder {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        Arrays.stream(traverseArray(arr,1)).forEach(i -> System.out.print(i + " "));
    }

    private static int[] traverseArray(int[] arr, int times) {
        int length = arr.length;
        int end = 0;
        int count = 0;
        int resultantArr[] = new int[length];

        while (count < times) {
            end = arr[length-1];

            for (int i = 1; i < length; i++) {
                resultantArr[i] = arr[i-1];
                resultantArr[0] = end;
            }
            arr = resultantArr.clone();
            count++;
        }
        return resultantArr;
    }
}
