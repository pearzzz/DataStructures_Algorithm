package com.pearz.data_structure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {1, 9, 52, 23, 3, 9, -1, 0};
//
//        shell(arr);
//
//        for (int ele : arr) {
//            System.out.printf("%d\t", ele);
//        }

        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; ++i) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(date);
        System.out.println(s);

        shell(arr);

        Date date2 = new Date();
        String s2 = simpleDateFormat.format(date2);
        System.out.println(s2);
    }

    public static void shell(int[] arr) {
        int l = arr.length, gap = l / 2, temp, n;

        while (gap > 0) {
            for (int m = gap; m < l; ++m) {
                n = m;
                temp = arr[n];
                if (arr[n] < arr[n - gap]) {
                    while (n >= gap && temp < arr[n - gap]) {
                        arr[n] = arr[n - gap];
                        n -= gap;
                    }
                    arr[n] = temp;
                }

            }
            gap = gap / 2;
        }
    }
}
