package com.pearz.data_structure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {1, 9, 52, 23, 3, 9, -1, 0};
//
//        Quick(arr, 0, arr.length - 1);
//
//        for (int ele : arr) {
//            System.out.printf("%d\t", ele);

        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; ++i) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(date);
        System.out.println(s);

        Quick(arr, 0, arr.length - 1);

        Date date2 = new Date();
        String s2 = simpleDateFormat.format(date2);
        System.out.println(s2);
    }

    public static void Quick(int[] arr, int start, int end) {
        int left = start, right = end, temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] > temp) {
                --right;
            }
            if (left < right) {
                arr[left] = arr[right];
                ++left;
            }
            while (left < right && arr[left] < temp) {
                ++left;
            }
            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
            arr[left] = temp;
        }
        if (start < left - 1) {
            Quick(arr, start, left - 1);
        }
        if (right + 1 < end) {
            Quick(arr, right + 1, end);
        }
    }
}
