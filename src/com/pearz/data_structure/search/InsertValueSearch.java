package com.pearz.data_structure.search;

import java.util.ArrayList;
import java.util.List;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 15, 15, 15, 15, 15, 45, 90};
        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 90));
    }

    public static List<Integer> insertValueSearch(int[] arr, int left, int right, int target) {
        if (left > right || target < arr[left] || target > arr[right]) {
            return new ArrayList<Integer>();
        }
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        if (target > arr[mid]) {
            return insertValueSearch(arr, mid + 1, right, target);
        } else if (target < arr[mid]) {
            return insertValueSearch(arr, left, mid - 1, target);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(mid);
            int l = 1;
            while (mid - l >= left && arr[mid - l] == target) {
                list.add(mid - l);
                ++l;
            }
            int r = 1;
            while (mid + r <= right && arr[mid + r] == target) {
                list.add(mid + r);
                ++r;
            }
            return list;
        }
    }
}
