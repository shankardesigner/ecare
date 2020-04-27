package com.shankardesigner.ecare.test;

import java.util.Arrays;

public class BinarySearch {
    public static boolean binarySearchIterative(int[] array, int x) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            System.out.println("processing...");
            if(array[mid] == x) {
                return true;
            } else if(x < array[mid]) {
                right = mid - 1;
            } else if(x > array[mid]) {
                left = mid + 1;
            }
        }
        return false;
    };

    public static boolean binarySearchRecursive(int[] arr, int x, int left, int right) {
        Arrays.sort(arr);
        System.out.println("Processing...");
        int mid = left + ((right - left) / 2);

        if(x == arr[mid]) {
            return true;
        }
        else if(x < arr[mid]) {
            return binarySearchRecursive(arr,x,left,mid - 1);
        } else {
            return binarySearchRecursive(arr, x, mid + 1, right);
        }
    };

    public static void main(String[] args) {
        int[] ints = {1, 8, 5, 8, 9, 3, 84, 96, 52, 30, 74, 31, 54, 74, 20, 54, 84,820, 95, 2};
        System.out.println("Arr length:- " + ints.length);
        //System.out.println(binarySearchIterative(new int[]{1,8,5,8,9,3,84,96,52,30,74,31,54,74,20,54,84,95,2},20));;
        System.out.println(binarySearchRecursive(ints,20,0,ints.length - 1));
    }
}
