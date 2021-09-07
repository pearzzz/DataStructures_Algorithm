package com.pearz.data_structure.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {9, 1, 52, 23, 3, 9};

        select(arr);

        for (int ele : arr) {
            System.out.printf("%d\t", ele);
        }

//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; ++i) {
//            arr[i] = (int) (Math.random() * 8000000);
//        }
//
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//        String s = simpleDateFormat.format(date);
//        System.out.println(s);
//
//        select(arr);
//
//        Date date2 = new Date();
//        String s2 = simpleDateFormat.format(date2);
//        System.out.println(s2);



    }

    public static void select(int[] arr) {
        int k, temp;
        for (int i = 0; i < arr.length; ++i) {
            k = i;
            for (int j = i; j < arr.length; ++j) {
                k = arr[k] < arr[j] ? k : j;
            }
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }
}
