package com.pearz.algorithm.binarysearch;

import com.pearz.data_structure.search.BinarySearch;

public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 10, 16, 20, 26, 60, 90};
        System.out.println(binarySearch(arr, 2));
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
