package com.pearz.data_structure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {9, 1, 52, 23, 3, 9, -9, 52, 0};
//
//        insert(arr);
//
//        for (int ele : arr) {
//            System.out.printf("%d\t", ele);
//        }

        int[] arr = new int[800000];
        for (int i = 0; i < 800000; ++i) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(date);
        System.out.println(s);

        insert(arr);

        Date date2 = new Date();
        String s2 = simpleDateFormat.format(date2);
        System.out.println(s2);
    }

    public static void insert(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; ++i) {
            int j = i + 1;
            temp = arr[j];
            if (arr[j] < arr[i]) {
                while (j > 0 && arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    --j;
                }
            }
            arr[j] = temp;
        }
    }
}
