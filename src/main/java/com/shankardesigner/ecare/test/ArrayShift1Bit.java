package com.shankardesigner.ecare.test;

public class ArrayShift1Bit {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        traverseArray(arr,4);
    }

    private static void traverseArray(int[] arr, int repeat) {
        int size = arr.length - 1;
        int end = 0;
        int count = 0;

        while (count < 1) {
            end = arr[size];

            for (int i = 0; i < size; i ++) {
                arr[i+1] = arr[i];
            }

            //arr[0] = end;

            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            count ++;
        }
    }
}
