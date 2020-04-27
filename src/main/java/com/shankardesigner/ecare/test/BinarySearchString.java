package com.shankardesigner.ecare.test;

public class BinarySearchString {
    public static void main(String[] args) {
        String[] arr = {"contribute", "geeks", "ide", "funny boy", "practice"};
        String searchString = "geeks";
        int index = searchStringFromArray(arr, searchString);

        System.out.println(index);
    }

    private static int searchStringFromArray(String[] arr, String x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int res = x.compareTo(arr[mid]);
            System.out.println("Result position right now:- " + res);
            if (res == 0) {
                return mid;
            } else if(res > 0 ) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    };
}
